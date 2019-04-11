INSERT INTO `user`(user_id, `password`, role, username, email, registration_date, enabled)
VALUES (1, '{bcrypt}$2a$04$895j3QqSIaZU1dt62X4ntepX6E8XFiGfshM6ghGUG3WXVM/gaQkmO', 'ADMIN', 'patryk', 'patryk@example.com', '2019-04-09 18:04:59', true),
       (2, 'abc', 'USER', 'marcin', 'marcin@example.com', '2015-03-11 11:13:51', true);

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

