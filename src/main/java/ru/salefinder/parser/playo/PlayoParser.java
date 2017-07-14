package ru.salefinder.parser.playo;

import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import ru.salefinder.model.Propose;
import ru.salefinder.parser.GenericParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Queue;

/**
 * Determines logic for parse https://playo.ru.
 */
public class PlayoParser extends GenericParser {
    /**
     * Default constructor.
     *
     * @param connection to website.
     * @param proposes   queue for Propose.
     */
    public PlayoParser(final Connection connection,
                       final Map<String, Propose> proposes) {
        super(connection, proposes);
    }

    @Override
    protected Map<String, Propose> parseSinglePage(final Document document) {
        // TODO: 14.07.17 Парсишь страницу jsoup и пихаешь в конструктор
        return null;
    }

    @Override
    public Iterator<Document> iterator() {
        return new PlayoPageBreaker(connection);
    }
}
