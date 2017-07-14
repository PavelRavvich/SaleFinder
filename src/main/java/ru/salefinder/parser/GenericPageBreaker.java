package ru.salefinder.parser;

import org.jsoup.Connection;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Iterator;

/**
 * Determines generic page backer algorithm.
 */
public abstract class GenericPageBreaker implements Iterator<Document> {
    /**
     * Connection to website.
     */
    private Connection connection;
    /**
     * Temp reference to next document for Iterator.
     */
    private Document document;

    /**
     * Default constructor.
     *
     * @param rootConnect connect to first page for parsing.
     */
    public GenericPageBreaker(final Connection rootConnect) {
        document = getDocument(connection = rootConnect);
    }

    @Override
    public boolean hasNext() {
        return !document.baseUri().equals("end") && containProposes(document);
    }

    /**
     * Check what page contain Proposes structure.
     *
     * @param document for check.
     * @return true if contain proposes, else false.
     */
    public abstract boolean containProposes(final Document document);

    /**
     * Algorithm of generate URL for next page.
     *
     * @return URL for next page.
     */
    public abstract String generateNextURL();

    @Override
    public Document next() {
        final Document doc = document;
        connection.url(generateNextURL());
        document = getDocument(connection);
        return doc;
    }

    /**
     * Get document HTML representation.
     *
     * @param connection to current page.
     * @return document HTML representation.
     */
    private Document getDocument(final Connection connection) {
        try {

            return connection.get();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Document("end");
    }
}
