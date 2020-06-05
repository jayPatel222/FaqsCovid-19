package com.example.faqscovid_19;

public class News {
    String source;
    String title;
    String urlImage;
    String dateTime;
    String link;

    public News(String source, String title, String link, String dateTime, String urlImage) {
        this.source = source;
        this.title = title;
        this.link = link;
        this.dateTime = dateTime;
        this.urlImage = urlImage;
    }

    public String getSource() {
        return source;
    }

    public String getTitle() {
        return title;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getLink() {
        return link;
    }
}
