package ru.salefinder.parser;

import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import ru.salefinder.model.Propose;

import java.util.Iterator;
import java.util.Map;
import java.util.Queue;

/**
 * Generic class for all parsers.
 */
public abstract class GenericParser implements Parser, Iterable<Document> {
    /**
     * Connection to website.
     */
    protected Connection connection;
    /**
     * Map for proposes. Key - name of product.
     */
    private Map<String, Propose> proposes;

    /**
     * Default constructor.
     *
     * @param connection to website.
     * @param proposes queue for Propose.
     */
    public GenericParser(final Connection connection,
                         final Map<String, Propose> proposes) {
        this.connection = connection;
        this.proposes = proposes;
    }

    public void parse() {
        for (final Document document : this) {
            proposes.putAll(parseSinglePage(document));
        }
    }

    /**
     * Parsing single page.
     *
     * @param doc downloaded site page.
     * @return all proposes from one page.
     */
    protected abstract Map<String ,Propose> parseSinglePage(final Document doc);

    /**
     * Site page iterator.
     *
     * @return iterator for proposes pages.
     */
    @Override
    public abstract Iterator<Document> iterator();
}
