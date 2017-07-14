package ru.salefinder.parser.gama;

import org.jsoup.Connection;

import org.jsoup.nodes.Document;
import ru.salefinder.model.Propose;
import ru.salefinder.parser.GenericParser;
import ru.salefinder.parser.GenericPageBreaker;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;

/**
 * Implementation parse logic for HTML structure http//:gama-gama.ru/.
 */
public class GamaParser extends GenericParser {
    /**
     * Default constructor.
     *
     * @param connection to website.
     * @param proposes   queue for Propose.
     */
    public GamaParser(final Connection connection,
                      final Map<String, Propose> proposes) {
        super(connection, proposes);
    }

    @Override
    protected Map<String, Propose> parseSinglePage(final Document document) {
        // TODO: 14.07.17 Парсишь страницу jsoup и пихаешь в конструктор
        final Map<String, Propose> result = new HashMap<>();



        //while(есть что парсить в document) {
            final Propose propose = new Propose();
            result.put(propose.getName(), propose);
        //}
        return result;
    }

    @Override
    public Iterator<Document> iterator() {
        return new GamaPageBecker(connection);
    }
}
