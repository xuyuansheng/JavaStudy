package com.java.study.javastudy.script

println 'Hello Groovy!'

//def sql = Sql.newInstance("jdbc:mysql://192.168.80.130:3306/test",
//        'root', '123456', 'com.mysql.cj.jdbc.Driver')
//
//sql.close()


def greeting = { "Hello, $it!" }
assert greeting('Patrick') == 'Hello, Patrick!'