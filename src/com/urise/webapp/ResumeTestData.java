package com.urise.webapp;

import com.urise.webapp.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ResumeTestData {
    public static void main(String[] args) {

        Map<ContactsType,String> contacts = new HashMap<>();//мапа с контактами

        contacts.put(ContactsType.PHONE, "+7(921) 855-0482");
        contacts.put(ContactsType.SKYPE, "grigory.kislin");
        contacts.put(ContactsType.EMAIL,"gkislin@yandex.ru");
        contacts.put(ContactsType.LINK,"Профиль LinkedIn" + "\n" +
                                        "Профиль GitHub" + "\n" +
                                        "Профиль Stackoverflow" + "\n" +
                                        "Домашняя страница");

        Map<SectionType, ContentSection> section = new HashMap<>();//мапа для создания резюме
        TextSection textSection = new TextSection();//создание текстовой области
        TextSection textSection2 = new TextSection();
        textSection.setTextField("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");//её наполнение

        section.put(SectionType.OBJECTIVE,textSection);//добавление в мапу заполненной позиции

        textSection2.setTextField("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.");

        section.put(SectionType.PERSONAL,textSection2);

        ListTextSection listTextSection = new ListTextSection();//создание списка текстовых областей

        ArrayList<String> strings = new ArrayList<>();//создание списка строк

        strings.add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", " +
                "\"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). " +
                "Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.");
        strings.add("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. " +
                "Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");
        strings.add("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. " +
                "Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. " +
                "Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.");
        strings.add("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, " +
                "Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.");
        strings.add("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). " +
                "Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. " +
                "Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).");
        strings.add("Реализация протоколов по приему платежей всех основных платежных системы России " +
                "(Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");

        listTextSection.setTextSections(strings);

        section.put(SectionType.ACHIEVEMENT,listTextSection);//

        ListTextSection listTextSection2 = new ListTextSection();
        ArrayList<String> strings2 = new ArrayList<>();

        strings2.add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        strings2.add("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        strings2.add("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle,");
        strings2.add("MySQL, SQLite, MS SQL, HSQLDB");
        strings2.add("Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy,");
        strings2.add("XML/XSD/XSLT, SQL, C/C++, Unix shell scripts,");
        strings2.add("Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, " +
                    "Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), " +
                    "Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).");
        strings2.add("Python: Django.");
        strings2.add("JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js");
        strings2.add("Scala: SBT, Play2, Specs2, Anorm, Spray, Akka");
        strings2.add("Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, " +
                    "DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.");
        strings2.add("Инструменты: Maven + plugin development, Gradle, настройка Ngnix,");
        strings2.add("администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer.");
        strings2.add("Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования");
        strings2.add("Родной русский, английский \"upper intermediate\"");

        listTextSection2.setTextSections(strings2);

        section.put(SectionType.QUALIFICATIONS,listTextSection2);


        ArrayList<Organization> organizations = new ArrayList<>();

        Organization organization = new Organization();
        organization.setName("Java Online Projects");
        organization.setWorkTime(LocalDate.of(2013,10,1),LocalDate.now());
        organization.setObjective("Автор проекта.");
        organization.setDescription("Создание, организация и проведение Java онлайн проектов и стажировок.");
        organizations.add(organization);

        Organization organization2 = new Organization();
        organization2.setName("Wrike");
        organization2.setWorkTime(LocalDate.of(2014,10,1),LocalDate.of(2016,1,1));
        organization2.setObjective("Старший разработчик (backend)");
        organization2.setDescription("Проектирование и разработка онлайн платформы управления проектами Wrike " +
                                    "(Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). " +
                                    "Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.");
        organizations.add(organization2);
        Organization organization3 = new Organization();
        organization3.setName("RIT Center");
        organization3.setWorkTime(LocalDate.of(2012,4,1),LocalDate.of(2014,10,1));
        organization3.setObjective("Java архитектор");
        organization3.setDescription("Организация процесса разработки системы ERP для разных окружений: релизная политика, " +
                "версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), " +
                "AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), " +
                "сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера " +
                "документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, " +
                "Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python");
        organizations.add(organization3);

        Organization organization4 = new Organization();
        organization4.setName("Yota");
        organization4.setWorkTime(LocalDate.of(2008,6,1),LocalDate.of(2010,12,1));
        organization4.setObjective("Ведущий специалист");
        organization4.setDescription("Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" " +
                "(GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). " +
                "Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)");
        organizations.add(organization4);

        Organization organization5 = new Organization();
        organization5.setName("Enkata");
        organization5.setWorkTime(LocalDate.of(2007,3,1),LocalDate.of(2008,6,1));
        organization5.setObjective("Разработчик ПО");
        organization5.setDescription("Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) " +
                                    "частей кластерного J2EE приложения (OLAP, Data mining).");
        organizations.add(organization5);

        Organization organization6 = new Organization();
        organization6.setName("Siemens AG");
        organization6.setWorkTime(LocalDate.of(2005,1,1),LocalDate.of(2007,2,1));
        organization6.setObjective("Разработчик ПО");
        organization6.setDescription("Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО " +
                                    "на мобильной IN платформе Siemens @vantage (Java, Unix).");
        organizations.add(organization6);

        Organization organization7 = new Organization();
        organization7.setName("Alcatel");
        organization7.setWorkTime(LocalDate.of(1997,9,1),LocalDate.of(2005,1,1));
        organization7.setObjective("Инженер по аппаратному и программному тестированию");
        organization7.setDescription("Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).");
        organizations.add(organization7);

        ListOrganization listOrganization = new ListOrganization();

        listOrganization.setOrganizations(organizations);

        section.put(SectionType.EXPERIENCE,listOrganization);

        ArrayList<Organization> organizations2 = new ArrayList<>();

        Organization organization8 = new Organization();
        organization8.setName("Coursera");
        organization8.setWorkTime(LocalDate.of(2013,3,1),LocalDate.of(2013,5,1));
        organization8.setObjective("\"Functional Programming Principles in Scala\" by Martin Odersky");
        organizations2.add(organization8);

        Organization organization9 = new Organization();
        organization9.setName("Luxoft");
        organization9.setWorkTime(LocalDate.of(2011,3,1),LocalDate.of(2011,4,1));
        organization9.setObjective("Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"");
        organizations2.add(organization9);

        Organization organization10 = new Organization();
        organization10.setName("Siemens AG");
        organization10.setWorkTime(LocalDate.of(2005,1,1),LocalDate.of(2005,4,1));
        organization10.setObjective("3 месяца обучения мобильным IN сетям (Берлин)");
        organizations2.add(organization10);

        Organization organization11 = new Organization();
        organization11.setName("Alcatel");
        organization11.setWorkTime(LocalDate.of(1997,9,1),LocalDate.of(1998,3,1));
        organization11.setObjective("6 месяцев обучения цифровым телефонным сетям (Москва)");
        organizations2.add(organization11);

        Organization organization12 = new Organization();
        organization12.setName("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики");
        organization12.setWorkTime(LocalDate.of(1993,9,1),LocalDate.of(1996,7,1));
        organization12.setObjective("Аспирантура (программист С, С++)");
        organizations2.add(organization12);

        Organization organization13 = new Organization();
        organization13.setName("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики");
        organization13.setWorkTime(LocalDate.of(1987,9,1),LocalDate.of(1993,7,1));
        organization13.setObjective("Инженер (программист Fortran, C)");
        organizations2.add(organization13);

        Organization organization14 = new Organization();
        organization14.setName("Заочная физико-техническая школа при МФТИ");
        organization14.setWorkTime(LocalDate.of(1984,9,1),LocalDate.of(1987,6,1));
        organization14.setObjective("Закончил с отличием");
        organizations2.add(organization14);

        ListOrganization listOrganization2 = new ListOrganization();
        listOrganization2.setOrganizations(organizations2);

        section.put(SectionType.EDUCATIONS,listOrganization2);







        Resume resume = new Resume("uuid1","Григорий Кислин",contacts,section);

        System.out.println(resume.toString());
    }
}
