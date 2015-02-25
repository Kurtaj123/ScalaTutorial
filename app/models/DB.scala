package models

/**
  * Created by sku on 2/24/2015.
  */

import sorm._

//case class Coffee(name: String, supplier: Supplier, price: Double, sales: Int, total: Int)
//case class Supplier(name: String, street: String, city: String, state: String, zip: String)


object DB extends Instance (
  entities = Set( Entity[Coffees]()),
  url = "jdbc:mysql://address=(protocol=tcp)(host=localhost)(port=3306)(user=root)(password='')/scala",
  initMode = InitMode.Create
)


