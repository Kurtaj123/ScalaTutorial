package models
import sorm._
import sorm.sql.Sql


/**
 * Created by sku on 2/24/2015.
 */
case class Coffees(cof_name: String,sup_id:Int, price: Int, sales: Int, total: Int)

object Coffees {

  def all(): List[Coffees] = Nil

  def create(userData: Coffees) { DB.save(userData)}

  def delete(id: Long) {}

}


case class User(name: String, age: Int)