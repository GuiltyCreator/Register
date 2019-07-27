package online.shixun.project.db.Factory

import online.shixun.project.db.DAO.IUserDAO
import online.shixun.project.db.DAO.UserDAOProxy

/**
 * 工厂类，通过工厂类取得一个DAO的实例化对象。
 *
 */
object DAOFactory{
    fun getIUserDAOInstance():IUserDAO=UserDAOProxy()
}