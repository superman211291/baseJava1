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
        textSection.setTextField("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");//её наполнение

        section.put(SectionType.OBJECTIVE,textSection);//добавление в мапу заполненной позиции

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

        strings.clear();//очищаем лист стрингов для дальнейшего наполнения другими данными

        strings.add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        strings.add("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        strings.add("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle,");
        strings.add("MySQL, SQLite, MS SQL, HSQLDB");
        strings.add("Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy,");
        strings.add("XML/XSD/XSLT, SQL, C/C++, Unix shell scripts,");
        strings.add("Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, " +
                    "Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), " +
                    "Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).");
        strings.add("Python: Django.");
        strings.add("JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js");
        strings.add("Scala: SBT, Play2, Specs2, Anorm, Spray, Akka");
        strings.add("Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, " +
                    "DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.");
        strings.add("Инструменты: Maven + plugin development, Gradle, настройка Ngnix,");
        strings.add("администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer.");
        strings.add("Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования");
        strings.add("Родной русский, английский \"upper intermediate\"");

        listTextSection.setTextSections(strings);

        section.put(SectionType.QUALIFICATIONS,listTextSection);

        strings.clear();

        ArrayList<Organization> organizations = new ArrayList<>();

        Organization organization = new Organization();
        organization.setName("Java Online Projects");
        organization.setWorkTime(LocalDate.of(2013,10,1),LocalDate.now());
        organization.setObjective("Автор проекта.");
        organization.setDescription("Создание, организация и проведение Java онлайн проектов и стажировок.");
        organizations.add(organization);

        organization.setName("Wrike");
        organization.setWorkTime(LocalDate.of(2014,10,1),LocalDate.of(2016,1,1));
        organization.setObjective("Старший разработчик (backend)");
        organization.setDescription("Проектирование и разработка онлайн платформы управления проектами Wrike " +
                                    "(Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). " +
                                    "Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.");
        organizations.add(organization);

        organization.setName("RIT Center");
        organization.setWorkTime(LocalDate.of(2012,4,1),LocalDate.of(2014,10,1));
        organization.setObjective("Java архитектор");
        organization.setDescription("Организация процесса разработки системы ERP для разных окружений: релизная политика, " +
                "версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), " +
                "AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), " +
                "сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера " +
                "документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, " +
                "Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python");
        organizations.add(organization);

        organization.setName("Yota");
        organization.setWorkTime(LocalDate.of(2008,6,1),LocalDate.of(2010,12,1));
        organization.setObjective("Ведущий специалист");
        organization.setDescription("Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" " +
                "(GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). " +
                "Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)");
        organizations.add(organization);

        organization.setName("Enkata");
        organization.setWorkTime(LocalDate.of(2007,3,1),LocalDate.of(2008,6,1));
        organization.setObjective("Разработчик ПО");
        organization.setDescription("Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) " +
                                    "частей кластерного J2EE приложения (OLAP, Data mining).");
        organizations.add(organization);

        organization.setName("Siemens AG");
        organization.setWorkTime(LocalDate.of(2005,1,1),LocalDate.of(2007,2,1));
        organization.setObjective("Разработчик ПО");
        organization.setDescription("Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО " +
                                    "на мобильной IN платформе Siemens @vantage (Java, Unix).");
        organizations.add(organization);

        organization.setName("Alcatel");
        organization.setWorkTime(LocalDate.of(1997,9,1),LocalDate.of(2005,1,1));
        organization.setObjective("Инженер по аппаратному и программному тестированию");
        organization.setDescription("Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).");
        organizations.add(organization);

        ListOrganization listOrganization = new ListOrganization();

        listOrganization.setOrganizations(organizations);

        section.put(SectionType.EXPERIENCE,listOrganization);

        organizations.clear();

        organization.setName("Coursera");
        organization.setWorkTime(LocalDate.of(2013,3,1),LocalDate.of(2013,5,1));
        organization.setObjective("\"Functional Programming Principles in Scala\" by Martin Odersky");
        organizations.add(organization);

        organization.setName("Luxoft");
        organization.setWorkTime(LocalDate.of(2011,3,1),LocalDate.of(2011,4,1));
        organization.setObjective("Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"");
        organizations.add(organization);

        organization.setName("Siemens AG");
        organization.setWorkTime(LocalDate.of(2005,1,1),LocalDate.of(2005,4,1));
        organization.setObjective("3 месяца обучения мобильным IN сетям (Берлин)");
        organizations.add(organization);

        organization.setName("Alcatel");
        organization.setWorkTime(LocalDate.of(1997,9,1),LocalDate.of(1998,3,1));
        organization.setObjective("6 месяцев обучения цифровым телефонным сетям (Москва)");
        organizations.add(organization);

        organization.setName("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики");
        organization.setWorkTime(LocalDate.of(1993,9,1),LocalDate.of(1996,7,1));
        organization.setObjective("Аспирантура (программист С, С++)");
        organizations.add(organization);

        organization.setName("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики");
        organization.setWorkTime(LocalDate.of(1987,9,1),LocalDate.of(1993,7,1));
        organization.setObjective("Инженер (программист Fortran, C)");
        organizations.add(organization);

        organization.setName("Заочная физико-техническая школа при МФТИ");
        organization.setWorkTime(LocalDate.of(1984,9,1),LocalDate.of(1987,6,1));
        organization.setObjective("Закончил с отличием");
        organizations.add(organization);

        listOrganization.setOrganizations(organizations);

        section.put(SectionType.EDUCATIONS,listOrganization);

        organizations.clear();



        Resume resume = new Resume("uuid1","Григорий Кислин",contacts,section);
    }
}
