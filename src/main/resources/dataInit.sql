insert into users (role, id, email, first_name, last_name, password, phone_number)
values ('ADMIN', 1, 'admin@gmail.com', 'Manas', 'Abdugani uulu',
        '$2a$12$xn.XL/ZseJtGODxaKtbqf.05yQlma3hGcxHFH/ywUl7w3yrlEORrW', '+996221010101'),--Admin123
       ('INSTRUCTOR', 2, 'aijamal@gmail.com', 'Aijamal', 'A',
        '$2a$12$28dRuthp7v2zllKPCjZsAOVQ9PztcbMUiifibAMa2J92hnSRnqx52', '+996221010101'),--instructor123
       ('INSTRUCTOR', 3, 'datka@gmail.com', 'Datka', 'M', '$2a$12$q4VHqHXBed9gw4ToiiGg9uQ3mWwrBnnGBy54E/UF4GzP2A3xAbEdy',
        '+996221010101'),--instructor321
       ('STUDENT', 4, 'baytik@gmail.com', 'Baytik', 'Taalaybekov',
        '$2a$12$VIrzHAe0rAklGWakK.rsQOH0cwynRNbWWHB8PkJ8b5SqBdpVQsyou', '+996221010101'),--student321
        ('STUDENT',5,'malik@gmail.com','Malik','Malikov','$2a$12$CyLOcsHqEsVjzx7Htir70uoAvBIunZiROf32K9XC2Nxb72aMMcFWu','0700123456'), --student123
        ('STUDENT',6,'aizat@gmail.com','Aizat','Aizatova','$2a$12$jjqTsweI.rgnK1lJb63u..nwbOor4AXW8MgfG8.kT5WmykCYM..1a','0700423456'); --student12345

insert into instructors(id, user_id, specialization)
VALUES (1, 2, 'INSTRUCTOR'),
       (2, 3, 'INSTRUCTOR');

insert into groups(create_date, id, description, group_name, image)
VALUES (now(), 1, 'Backend', 'Java-9', 'groups java'),
       (now(), 2, 'Frontend', 'JavaScript-9', 'groups js'),
       (now(), 3, 'Backend', 'Python-9', 'groups python');

insert into students(group_id, id, user_id, study_format)
VALUES (1, 1, 4, 'ONLINE'),
       (2, 2, 5, 'OFFLINE'),
       (3, 3, 6, 'ONLINE');

insert into courses(date, group_id, id, course_name, description, image)
VALUES (now(), 1, 1, 'Java', 'Backend', 'course photo'),
       (now(), 2, 2, 'JavaScript-9', 'Frontend', 'course photo'),
       (now(), 3, 3, 'Python-9', 'Backend', 'course photo');

insert into courses_instructors(courses_id, instructors_id)
VALUES (1,1),
       (2,2),
       (3,3);

insert into lessons(course_id, id, lesson_name)
VALUES (1, 1, 'Array'),
       (2, 2, 'Loop'),
       (3, 3, 'OOP');

insert into presentations(id, lesson_id, description, format, name)
VALUES (1, 1, 'Arrays explanation', 'String', 'Array'),
       (2, 2, 'Loop explanation', 'String', 'Loop'),
       (3, 3, 'Loop ', 'String', 'OOP');

insert into video_lessons(id, lesson_id, description, link, name)
VALUES (1, 1, 'Array', 'link lesson', 'Lesson'),
       (2, 2, 'Loop', 'link lesson', 'Lesson'),
       (3, 3, 'Loop', 'OOP lesson', 'Lesson');

insert into tasks(id, lesson_id, task_name)
VALUES (1, 1, 'Task code'),
       (2, 2, 'Task code'),
       (3, 3, 'Task code');

insert into links(id, lesson_id, link, text)
VALUES (1, 1, 'Link to information', 'Array'),
       (2, 2, 'Link to information', 'Loop'),
       (3, 3, 'Link ', 'OOP');

insert into tests(id,name,is_enable,lesson_id)
VALUES (1,'testingOOP',true,1),
       (2,'testHibernate',false,2),
       (3,'testJDBC',true,3);

insert into questions(id,question_name,question_type,test_id)
VALUES (1,'OOP','SINGLE',1),
       (2,'JDBC','MULTIPLE',2),
       (3,'JDBCTEMPLATE','SINGLE',3);

insert into test_answers(id,test_name,correct,in_correct,point,is_accepted,test_id,student_id)
VALUES (1,'testingOP',2,3,5,true,1,1),
       (2,'testingHibernate',3,4,4,false,2,2),
       (3,'testingOP',2,3,5,true,1,1);

insert into task_data(data_key,task_id,data)
VALUES ('3',1,'String'),
       ('4',2,'String'),
       ('5',3,'String');

insert into task_answers(id,file,text,comment,task_answer_status,student_id,task_id)
VALUES (1,'file','text','comment','ACCEPTED',1,1),
       (2,'file','text','comment','REJECTED',2,2),
       (3,'file','text','comment','ACCEPTED',3,3);

insert into option_tests(id,is_true,question_id,option)
VALUES (1,false,1,'String'),
       (2,true,2,'String'),
       (3,false,3,'String');

insert into question_answers(id,point,question_id,test_answer_id)
VALUES (1,2,2,1),
       (2,3,2,2),
       (3,4,3,3);

insert into question_answers_option(option_id, question_answer_id)
Values (1,1),
       (2,2),
       (3,3);
