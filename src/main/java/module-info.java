module me.prouge.mazebank {
    requires javafx.controls;
    requires me.prouge.guicefx;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires jakarta.inject;
    requires com.google.guice;
    requires org.hibernate.orm.core;
    requires org.reflections;
    requires static lombok;
    requires org.apache.logging.log4j;

    opens me.prouge.template;
    opens me.prouge.template.entities;
    opens me.prouge.template.controllers;
    opens me.prouge.template.utils;
    opens me.prouge.template.views;
    opens me.prouge.template.service;

    exports me.prouge.template;
}
