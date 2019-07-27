package online.shixun.project.service

import online.shixun.project.db.Factory.DAOFactory
import online.shixun.project.model.User

class UserService{
    //创建 UserDao 实例
   // private val userDAO=DAOFactory.getIUserDAOInstance()

    /**
     * 保存用户：先根据用户名称查询判断用户是否已经存在于数据库中，如果存在，返回失败；如果不存在，插入到数据库
     * @param user 用户信息
     * @return 是否成功保存用户
     * @throws SQLException sql 异常
     */
    fun saveUser(user: User):Boolean{
        var flag=false
        println("开始查找:${user.username}")
        val dbUser=DAOFactory.getIUserDAOInstance().findUserByUsername(user.username)
        /*dbUser.let {
        println("dbUser!=null!")
            flag=userDAO.creatUser(user)
        }*/
        if(dbUser!=null){
            println("已有此用户存在")
            flag=false
        }

        if(DAOFactory.getIUserDAOInstance().creatUser(user)){
            flag=true
            println("创建成功")
        }

        println("flag:$flag")
        return flag
    }
}