package com.example.mylibrary;

import android.content.res.AssetManager;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class BookList {

    private List<Book> books;

    public BookList(AssetManager assets) {
        books = new ArrayList<>();

        try {
            InputStream is = assets.open("library.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("book");

            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    String title = element
                            .getElementsByTagName("title")
                            .item(0)
                            .getTextContent();

                    String writer = element
                            .getElementsByTagName("writer")
                            .item(0)
                            .getTextContent();

                    String description = element
                            .getElementsByTagName("description")
                            .item(0)
                            .getTextContent();

                    books.add(new Book(title, writer, description));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book getBook(long id) {

        if (id < 0 || id >= books.size()) {
            return null;
        }
        return books.get((int) id);
    }
}