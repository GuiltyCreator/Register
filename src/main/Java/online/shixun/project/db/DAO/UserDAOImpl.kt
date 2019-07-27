package online.shixun.project.db.DAO

import online.shixun.project.model.User
import java.beans.Expression
import java.lang.Exception
import java.sql.*

/**
 * DAO接口的真实实现类，主要完成具体数据库操作，但不负责数据库的打开和关闭；
 *
 */
class UserDAOImpl(val conn:Connection):IUserDAO{

    private var pstmt : PreparedStatement?=null

    override fun findUserByUsername(username:String): User? {
        var user:User?=null
        // 按照用户名称查询用户信息SQL
        val sql="select * from qsx_register where username=?"
        println("开始查询")
        try {
            this.pstmt=this.conn.prepareStatement(sql)
            //设置查询条件
            this.pstmt?.setString(1,username)
            // 执行SQL查询，得到结果集
            val rs=this.pstmt!!.executeQuery()
            // 遍历结果集
            while (rs.next()){
                user?.id=rs.getLong("id")
                user?.username=rs.getString(username)
                user?.password=rs.getString("password")
                user?.email=rs.getString("email")
                user?.gender=rs.getString("gender")
                user?.profession=rs.getString("profession")
                user?.hobby=rs.getString("hobby").split(",").toTypedArray()
                break
            }
        }
        catch (e :Exception){
            println("查询出错")
            e.printStackTrace()
        }

        try {
            // 关闭数据库连接，释放资源
            this.pstmt!!.close()
        }
        catch (e:Exception){
            println("PreparedStatement 关闭错误")
            e.printStackTrace()
        }
        println("查询结束：${user?.username}")
        return user
    }

    override fun creatUser(user: User) :Boolean{
        var flag=false
        val sql="insert into qsx_register(username, password, email, gender, profession, hobby) value (?,?,?,?,?,?)"
        try {
            this.pstmt=this.conn.prepareStatement(sql)
            // 设置插入参数
            println("设置插入参数")
            this.pstmt?.setString(1,user.username)
            this.pstmt?.setString(2,user.password)
            this.pstmt?.setString(3,user.email)
            this.pstmt?.setString(4,user.gender)
            this.pstmt?.setString(5,user.profession)
            this.pstmt?.setString(6,user.hobbyString)
            // 执行 sql 语句并得到影响的条数,如果等于1则说明插入成功
            if(this.pstmt!!.executeUpdate()==1)
                flag=true

        }catch (e:Exception){
            println("插入失败")
            e.printStackTrace()
        }

        try {
            // 关闭数据库连接，释放资源
            this.pstmt!!.close()
        }
        catch (e:Exception){
            println("PreparedStatement 关闭错误")
            e.printStackTrace()
        }

        return flag
    }
}