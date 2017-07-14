package ru.salefinder.parser.playo;

import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import ru.salefinder.parser.GenericPageBreaker;

/**
 * Page breaker for Playo.ru.
 */
public class PlayoPageBreaker extends GenericPageBreaker {
    /**
     * Default constructor.
     *
     * @param rootConnect connect to first page for parsing.
     */
    public PlayoPageBreaker(Connection rootConnect) {
        super(rootConnect);
    }

    @Override
    public boolean containProposes(Document document) {
        // TODO: 14.07.17 Проверяешь что страница соответствует структуре странице с товарамию
        return false;
    }

    @Override
    public String generateNextURL() {
        // TODO: 14.07.17 Генерируешь URL очередной страницы для данного сайта
        return null;
    }
}
