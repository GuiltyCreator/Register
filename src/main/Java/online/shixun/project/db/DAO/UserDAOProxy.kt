package online.shixun.project.db.DAO

import online.shixun.project.db.dbc.DatabaseConnection
import online.shixun.project.model.User
import java.lang.Exception

/**
 * 代理实现类，主要完成数据库的打开和关闭并且调用真实实现类对象的操作；
 *
 */
class UserDAOProxy:IUserDAO{

    private lateinit var dbc: DatabaseConnection
    private  var dao:IUserDAO

    init {
        try {
            this.dbc= DatabaseConnection("jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8", "root", "1234")
        }
       catch (e:Exception){
           println("DatabaseConnection初始化错误")
           e.printStackTrace()
       }
        this.dao=UserDAOImpl(this.dbc.conn!!)
    }

    override fun findUserByUsername(username: String): User?{
        var user:User?=null
        try {
            user=this.dao.findUserByUsername(username)
        }
        catch (e:Exception){
            println("Proxy查询出错")
            e.printStackTrace()
        }finally {
            this.dbc.close()
        }
        return user
    }

    override fun creatUser(user: User): Boolean {
        var flag=false
        try {
            flag=this.dao.creatUser(user)
        }
        catch (e:Exception){
            println("Proxy插入出错")
            e.printStackTrace()
        }finally {
            this.dbc.close()
        }
        return flag
    }

}