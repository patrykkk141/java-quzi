INSERT INTO `user`(user_id, `password`, role, username, email, registration_date, enabled)
VALUES (1, '{bcrypt}$2a$04$895j3QqSIaZU1dt62X4ntepX6E8XFiGfshM6ghGUG3WXVM/gaQkmO', 'ADMIN', 'patryk', 'patryk@example.com', '2019-04-09 18:04:59', true),
       (2, 'abc', 'USER', 'marcin', 'marcin@example.com', '2015-03-11 11:13:51', true);

INSERT INTO `question` (`question_id`, `code`, `creation_date`, `img_url`, `text`) VALUES
(1, 'public String saveImage(MultipartFile file) throws IOException, FileException {\r\n        if (file != null && !file.isEmpty()) {\r\n            String ext = getFileExtension(file.getOriginalFilename());\r\n            if (isImage(ext)) {\r\n                String name = UUID.randomUUID().toString().concat(ext);\r\n                File f = new File(folder + name);\r\n                f.createNewFile();\r\n                file.transferTo(f);\r\n                return API_IMAGE_URL + name;\r\n            }\r\n            throw new FileException(\"File is not an image!\");\r\n        }\r\n        throw new FileException(\"File is empty!\");\r\n    ', NULL, 'http://localhost:8080/image/a3fb8e1c-ae3c-4a27-87c9-6d6d61d69557.png', 'Która składnia dodawania obiektu panelu (JPanel panel = new JPanel();) do kontenera okna (JFrame frame = new JFrame();) w języku Java jest poprawna'),
(2, '  private String getFileExtension(String s) {\r\n        if (s.lastIndexOf(\".\") > 0)\r\n            return s.substring(s.lastIndexOf(\".\"));\r\n        else return null;\r\n    }', NULL, 'http://localhost:8080/image/818b60bb-435c-46d0-b50e-2545b17d2a37.jpg', 'W języku Java rozkład komponentów (przycisków) w oknie aplikacji jak na rysunku niżej realizuje klasa (równa siatka przycisków 3x2 tej samej wielkości)'),
(3, NULL, '2015-03-11 11:13:51', NULL, 'Interfejsy funkcyjne:  '),
(4, NULL, '2015-03-11 11:13:51', NULL, 'Parser strumieniowy StAX pozwala na:'),
(5, NULL, NULL, 'http://localhost:8080/image/8d055705-38b2-48a7-af62-832f8cbaf6c5.png', 'Który kod jest poprawny:'),
(6, NULL, '2015-03-11 11:13:51', NULL, 'JavaFX: '),
(7, NULL, '2015-03-11 11:13:51', NULL, 'FXML'),
(8, NULL, '2015-03-11 11:13:51', NULL, 'Klasa WebEngine i WebView języka JavaFX pozwala na budowowę przeglądarki Web która przetwarza: '),
(9, ' @GetMapping(\"/api/quiz\")\r\n    public ResponseEntity<QuizDto> generateQuiz() throws BadRequestException, NotFoundException {\r\n        return generateQuizWithParams(quizProperties.getQuizLength(),\r\n                quizProperties.getQuizType(),\r\n                quizProperties.getAnswersQuantity(),\r\n                quizProperties.getQuizTimeInMillis());\r\n    ', NULL, 'http://localhost:8080/image/c892e083-75b5-4a35-b7b2-a06e0fc602d1.png', 'Tworzenie obiektu Klasy komponentu JavaFX (...) '),
(10, NULL, '2015-03-11 11:13:51', NULL, 'Prawidłowa definicja interfejsu Interfacename: '),
(11, NULL, NULL, 'http://localhost:8080/image/297e4531-4db0-4972-a1a0-766921e86446.png', 'Która składnia umożliwia przeprowadzenie parsowania pliku języka XML za pomoca interfejsu SAX języka Java: '),
(12, 'class B {\r\n}\r\n\r\npublic class A extends B {\r\n    }', NULL, NULL, 'Która składnia tworzenia nowego obiektu o nazwie obj jest poprawna ?'),
(13, 'class B {\r\n        void message() {\r\n            System.out.println(\"B\");\r\n        }\r\n    }\r\n\r\n    class A\r\n    extneds B\r\n    {\r\n\r\n        void message() {\r\n            System.out.println(\"A\");\r\n        }\r\n\r\n        void display() {\r\n            this.message();\r\n            super.message();\r\n        }\r\n\r\n        public static void main(String[] args) {\r\n            A a = new A();\r\n            a.display();\r\n        }\r\n}', NULL, NULL, 'Wykonanie poniższego kodu powoduje wyświetlenie'),
(14, NULL, NULL, NULL, 'Które modyfikatory dostępu w języku Java są poprawne ?'),
(15, NULL, NULL, NULL, 'Która z kolekcji pozwoli na przechowywanie unikalnych wartości w posortowany sposób ?'),
(16, NULL, NULL, NULL, 'Interfejsy w języku Java mogą posiadać:'),
(17, NULL, NULL, NULL, 'Która z adnotacji pozwala na utworzenie Beana przez skanowanie pakietów we framweorku Spring ?'),
(18, NULL, NULL, NULL, 'Jak utworzyć destruktor w w Javie ?'),
(19, NULL, NULL, NULL, 'Zaznacz implementacje JPA:'),
(20, NULL, NULL, NULL, 'W jaki sposób utworzy ArrayList z istniejącej tablicy typu int?'),
(21, 'class Counter {\r\n    private int value;\r\n\r\n    public void increment() {\r\n                value += 1;\r\n    }\r\n\r\n    public int getValue() {\r\n        return value;\r\n    }\r\n}', NULL, NULL, 'W jaki sposób zapewnić bezpieczeństwo dla metody increment() przy pracy z wieloma wątkami ?'),
(22, NULL, NULL, NULL, 'Która technologia pozwoli na stworzenie GUI w języku Java które będzie wyglądało tak samo na systemach z rodziny Windows/UNIX oraz znajduje się w SDK?'),
(23, NULL, NULL, NULL, 'W której wersji Javy zostały wprowadzone wyrażenia lambda oraz strumienie ?'),
(24, NULL, NULL, NULL, 'Który element Javy pozwala przetwarzanie HTTP ?'),
(26, NULL, NULL, NULL, 'Która składnia tworzenia strumienia jest poprawna ?'),
(27, NULL, NULL, NULL, 'Zaznacz interfejsy funkcyjne znajdujące się w pakiecie java.util.function'),
(28, NULL, NULL, NULL, 'Który interfejs funkcyjny przyjmuje downolną wartość i zwraca wartość typu bool ?'),
(29, NULL, NULL, NULL, 'Którego interfejsu funkcyjnego użyjesz to zakończenia strumienia i zwrócenia go w postaci Listy?'),
(30, NULL, NULL, NULL, 'Co jest wymagane aby połączyć się z bazą danych ?');


INSERT INTO `answer` (`answer_id`, `answer_type`, `text`, `question_id`) VALUES
(1, 'POSITIVE', 'frame.add(panel);', 1),
(2, 'NEGATIVE', 'panel.add(frame);', 1),
(3, 'POSITIVE', 'frame.getContentPane().add(panel);', 1),
(4, 'NEGATIVE', 'frame.remove(panel);', 1),
(5, 'NEGATIVE', 'FlowLayout', 2),
(6, 'POSITIVE', 'GridLayout', 2),
(7, 'NEGATIVE', 'BorderLayout', 2),
(8, 'NEGATIVE', 'BoxLayout', 2),
(10, 'POSITIVE', 'java.util.function', 3),
(11, 'NEGATIVE', 'java.lang.Comparaable<T> ', 3),
(12, 'NEGATIVE', 'java.awt.ActionListener ', 3),
(13, 'NEGATIVE', 'java.awt.MouseListener', 3),
(14, 'POSITIVE', 'Odczyt i zapis dokumentów XML ', 4),
(15, 'NEGATIVE', 'Tylko odczyt dokumentów XML ', 4),
(16, 'NEGATIVE', 'Tylko zapis dokumentów XML ', 4),
(17, 'NEGATIVE', 'Nie jest obsługiwany w języku JAVA', 4),
(18, 'NEGATIVE', '@Interface public interface A{void method();} ', 5),
(19, 'NEGATIVE', '@FunctionalInterface public interface A{} ', 5),
(20, 'NEGATIVE', '@FunctionalInterface public interface A{void method1();void method2();} ', 5),
(21, 'POSITIVE', '@FunctionalInterface public interface A{void method();} ', 5),
(22, 'NEGATIVE', 'jest językiem skryptowym', 6),
(23, 'POSITIVE', 'nie jest językiem skryptowym', 6),
(24, 'POSITIVE', 'obsługuje wyrażenia lambda ', 6),
(25, 'NEGATIVE', 'nie pamiętam, ale by?ł to niepoprawna odpowied?', 6),
(26, 'NEGATIVE', 'jest kompilowalny ', 7),
(27, 'POSITIVE', 'odpowiada za interfejs użytkownika dla javy fx ', 7),
(28, 'NEGATIVE', 'nie pamiętam ', 7),
(29, 'POSITIVE', 'jest językiem opisowym ', 7),
(30, 'POSITIVE', 'HTML z CSS ', 8),
(31, 'NEGATIVE', 'kod źródłowy języka Java', 8),
(32, 'POSITIVE', 'kod języka JavaScript', 8),
(33, 'POSITIVE', 'HTML DOM', 8),
(34, 'POSITIVE', 'FileChooser ch = new FileChooser(); ', 9),
(35, 'NEGATIVE', 'JFileChooser ch = new JFileChooser(); ', 9),
(36, 'NEGATIVE', 'Chooser ch = new Chooser(); ', 9),
(37, 'NEGATIVE', 'FXChooser ch = new FXChooser(); ', 9),
(38, 'POSITIVE', 'public interface Interfacename extends Otherinterface ', 10),
(39, 'POSITIVE', 'public interface Interfacename extends Otherinterface1, Otherinterface2 ', 10),
(40, 'NEGATIVE', 'public interface Interfacename implements Otherinterface ', 10),
(41, 'NEGATIVE', 'public interface Interfacename implements Otherinterface1, Otherinterface2 ', 10),
(42, 'POSITIVE', 'parser.parse(source, handler); ', 11),
(43, 'NEGATIVE', 'transformer.transform(source, result); ', 11),
(44, 'NEGATIVE', 'validator.validate(source); ', 11),
(45, 'NEGATIVE', 'parser.parse(source);', 11),
(46, 'NEGATIVE', 'A obj = new A();', 12),
(47, 'NEGATIVE', 'A obj = new B();', 12),
(48, 'POSITIVE', 'B obj=new B();', 12),
(49, 'NEGATIVE', 'B obj = new A();', 12),
(50, 'NEGATIVE', 'BA', 13),
(51, 'POSITIVE', 'AB', 13),
(52, 'NEGATIVE', 'A', 13),
(53, 'NEGATIVE', 'B', 13),
(54, 'NEGATIVE', 'Błąd kompilacji', 13),
(55, 'NEGATIVE', 'Błąd wykonania', 13),
(56, 'POSITIVE', 'public', 14),
(57, 'POSITIVE', 'private', 14),
(58, 'POSITIVE', 'package-private', 14),
(59, 'POSITIVE', 'protected', 14),
(60, 'NEGATIVE', 'static', 14),
(61, 'NEGATIVE', 'ArrayList', 15),
(62, 'NEGATIVE', 'LinekdList', 15),
(63, 'NEGATIVE', 'LinkedHashSet', 15),
(64, 'NEGATIVE', 'LinkedHashMat', 15),
(65, 'NEGATIVE', 'PriorityQueue', 15),
(66, 'POSITIVE', 'TreeSet', 15),
(67, 'POSITIVE', 'metody statyczne', 16),
(68, 'POSITIVE', 'metody domyślne', 16),
(69, 'POSITIVE', 'stałe', 16),
(70, 'NEGATIVE', 'zmienne', 16),
(71, 'NEGATIVE', 'implementacje metod', 16),
(72, 'NEGATIVE', 'prywatne metody', 16),
(73, 'NEGATIVE', '@Bean', 17),
(74, 'POSITIVE', '@Component', 17),
(75, 'NEGATIVE', '@Configuration', 17),
(76, 'NEGATIVE', '@Enitity', 17),
(77, 'NEGATIVE', 'public destructor ClassName() {};', 18),
(78, 'NEGATIVE', 'public finalize() {};', 18),
(79, 'NEGATIVE', 'gc.finalize() {};', 18),
(80, 'NEGATIVE', 'W Javie nie można utworzyć destruktora', 18),
(81, 'NEGATIVE', 'Spring ', 19),
(82, 'POSITIVE', 'Hibernate', 19),
(83, 'POSITIVE', 'TopLink', 19),
(84, 'POSITIVE', 'Kodo', 19),
(85, 'NEGATIVE', 'new ArrayList<int>(tablica);', 20),
(86, 'NEGATIVE', 'new ArrayList(Arrays.asList(tablica));', 20),
(87, 'NEGATIVE', 'new List(List.asList(tablica));', 20),
(88, 'POSITIVE', 'new ArrayList<Integer>(Arrays.asList(tablica));', 20),
(89, 'POSITIVE', 'synchronized(this){ value++; }', 21),
(90, 'NEGATIVE', 'synchronized(int) { value++;}', 21),
(91, 'NEGATIVE', 'synchronized(value) { value++; }', 21),
(92, 'POSITIVE', 'synchronized(Conter.class) { value++};', 21),
(93, 'NEGATIVE', 'synchronized() {value++;}', 21),
(94, 'NEGATIVE', 'JavaFX', 22),
(95, 'NEGATIVE', 'AWT', 22),
(96, 'POSITIVE', 'Swing', 22),
(97, 'NEGATIVE', 'Spring Boot', 22),
(98, 'NEGATIVE', 'Jersey', 22),
(99, 'POSITIVE', '1.8', 23),
(100, 'NEGATIVE', '1.9', 23),
(101, 'NEGATIVE', '1.6', 23),
(102, 'NEGATIVE', '1.5', 23),
(103, 'NEGATIVE', '1.4', 23),
(104, 'NEGATIVE', '1.11', 23),
(105, 'NEGATIVE', 'MIDLET', 24),
(106, 'NEGATIVE', 'APLET', 24),
(107, 'NEGATIVE', 'KOTLET', 24),
(108, 'POSITIVE', 'SERVLET', 24),
(109, 'NEGATIVE', 'INNYLET', 24),
(114, 'POSITIVE', 'IntStream.of(1, 2, 3, 4);', 26),
(115, 'POSITIVE', 'IntStream.range(1, 4);', 26),
(116, 'POSITIVE', 'IntStream.rangeClosed(1,4);', 26),
(117, 'POSITIVE', 'IntStream.range(1,4).max().getAsInt();', 26),
(118, 'POSITIVE', 'Function <T, R>', 27),
(119, 'POSITIVE', 'Consumer <T>', 27),
(120, 'POSITIVE', 'Supplier <T>', 27),
(121, 'POSITIVE', 'Predicate <T>', 27),
(122, 'POSITIVE', 'UnaryOperator <T, T>', 27),
(123, 'NEGATIVE', 'Function <T, R>', 28),
(124, 'NEGATIVE', 'Consumer <T>', 28),
(125, 'NEGATIVE', 'Supplier <T>', 28),
(126, 'POSITIVE', 'Predicate <T>', 28),
(127, 'NEGATIVE', 'UnaryOperator <T, T>', 28),
(128, 'NEGATIVE', 'Function <T, R>', 29),
(129, 'POSITIVE', 'Consumer <T>', 29),
(130, 'NEGATIVE', 'Supplier <T>', 29),
(131, 'NEGATIVE', 'Predicate <T>', 29),
(132, 'NEGATIVE', 'UnaryOperator <T, T>', 29),
(133, 'POSITIVE', 'Sterownik bazy danych', 30),
(134, 'NEGATIVE', 'Pakiet org.sun.sql', 30),
(135, 'NEGATIVE', 'Obsluga bazy danych jest wbudowana w Jave', 30),
(136, 'NEGATIVE', 'W Javie nie mozna polaczyc sie z baza danych', 30);