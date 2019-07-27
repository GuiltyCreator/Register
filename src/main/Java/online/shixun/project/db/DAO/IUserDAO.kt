package online.shixun.project.db.DAO

import online.shixun.project.model.User

/**
 * 主要定义操作的接口，定义一系列数据库的原子性操作，例如增删改查等；
 */
interface IUserDAO{
    /**
     * 根据用户查找用户资料
     *@param username 用户名称
     * @return 用户对象
     */
    fun findUserByUsername(username:String):User?
    /**
     * 创建用户
     * @param user 用户对象
     * @return 影响的条数，true表示成功插入数据库，false表示未插入数据库
     */
    fun creatUser(user:User):Boolean
}