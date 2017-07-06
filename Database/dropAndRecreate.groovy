import groovy.sql.Sql

//use teh spring props for db details
Properties props = new Properties()
props.load(new File('../src/main/config/development/spring.properties').newDataInputStream())



String dataBase="time_survey"
String host= props.getProperty('db.host')
String uName = props.getProperty('db.username')
String pwd =props.getProperty('db.password')
//----------------------------------------------------------------------------------------------------------------------
/*
  splits an sql file (with many statements) on statement separators and runs each in turn using the  supplied sql
 */

def runEachStmtInScript(sqlString, sql) {


    sqlString.split(";").each { subQry ->
        if (subQry.trim() != '') {
            print(subQry)
            sql.execute(subQry)
        }
    }
}

//----------------- dataBase ----------------------------------------------------------------------
//
//sql = Sql.newInstance("jdbc:mysql://${host}:3306?jdbcCompliantTruncation=false&;useUnicode=true&;characterEncoding=UTF-8", uName, pwd, "com.mysql.jdbc.Driver")
//sql.execute("DROP DATABASE IF EXISTS ${dataBase}".toString())
//sql.execute("CREATE DATABASE ${dataBase}".toString())


sql = Sql.newInstance("jdbc:mysql://${host}:3306/${dataBase}?jdbcCompliantTruncation=false&;useUnicode=true&;characterEncoding=UTF-8", uName, pwd, "com.mysql.jdbc.Driver")

//create tables
String sqlFilePath = "dropAndReCreateDB.sql"
sqlFile = new File(sqlFilePath)
String sqlString = new File(sqlFilePath).getText()
//sqlString will have a number of stmts so run each in turn
runEachStmtInScript(sqlString, sql)
