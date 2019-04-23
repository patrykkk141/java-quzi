INSERT INTO `user`(user_id, `password`, role, username, email, registration_date, enabled)
VALUES (1, '{bcrypt}$2a$04$895j3QqSIaZU1dt62X4ntepX6E8XFiGfshM6ghGUG3WXVM/gaQkmO', 'ADMIN', 'patryk', 'patryk@example.com', '2019-04-09 18:04:59', true),
       (2, 'abc', 'USER', 'marcin', 'marcin@example.com', '2015-03-11 11:13:51', true);

INSERT INTO `question` (`question_id`, `img_url`, `text`) VALUES
(1, NULL, 'Która sk?adnia dodawania obiektu panelu (JPanel panel = new JPanel();) do kontenera okna (JFrame frame = new JFrame();) w j?zyku Java jest poprawna'),
(2, NULL, 'W j?zyku Java rozk?ad komponentów (przycisków) w oknie aplikacji jak na rysunku ni?ej realizuje klasa (równa siatka przycisków 3x2 tej samej wielko?ci)'),
(3, NULL, 'Interfejsy funkcyjne:  '),
(4, NULL, 'Parser strumieniowy StAX pozwala na:'),
(5, NULL, 'Który kod jest poprawny:'),
(6, NULL, 'JavaFX: '),
(7, NULL, 'FXML'),
(8, NULL, 'Klasa WebEngine i WebView języka JavaFX pozwala na budowę przeglądarki Web która przetwarza: '),
(9, NULL, 'Tworzenie obiektu Klasy komponentu JavaFX (...) '),
(10, NULL, 'Prawidłowa definicja interfejsu Interfacename: ');

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
  (25, 'NEGATIVE', 'nie pamiętam, ale była to niepoprawna odpowiedź', 6),
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
  (41, 'NEGATIVE', 'public interface Interfacename implements Otherinterface1, Otherinterface2 ', 10);

INSERT INTO `quiz`
VALUES (1, '2019-04-09 18:04:59', null, 1);

INSERT INTO `quiz_question`
VALUES (1, 1, 1),
       (2, 2, 1);

INSERT INTO `quiz_question_answer`
VALUES (1, 1, 1),
       (2, 2, 1),
       (3, 3, 1),
       (4, 4, 1);