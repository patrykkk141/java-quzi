INSERT INTO `user`
VALUES (1, 'abc', 'ADMIN', 'patryk'),
       (2, 'abc', 'USER', 'marcin');

INSERT INTO `question`
VALUES (1, null, 'Która składnia dodawania obiektu panelu (JPanel panel = new JPanel();) do kontenera okna (JFrame frame = new JFrame();) w języku Java jest poprawna'),
       (2, null, 'W języku Java rozkład komponentów (przycisków) w oknie aplikacji jak na rysunku niżej realizuje klasa (równa siatka przycisków 3x2 tej samej wielkości)');

INSERT INTO `answer`
VALUES (1,1, 'frame.add(panel);',1),
       (2,0, 'panel.add(frame);',1),
       (3,1, 'frame.getContentPane().add(panel);',1),
       (4,0, 'frame.remove(panel);',1),
       (5,0, 'FlowLayout',2),
       (6,1, 'GridLayout',2),
       (7,0, 'BorderLayout',2),
       (8,0, 'BoxLayout',2);

INSERT INTO `test_history`
VALUES(1, '2019-01-03', 30, 15, 1);