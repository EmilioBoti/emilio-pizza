package com.example.emiliopizza.views.models

import com.example.emiliopizza.views.interfaces.ModelData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Model() : ModelData {
    val email: String = "admin@gmail.com"
    val password: String = "1234"

    val listOrders = arrayListOf<Order>(
        Order("Patata", 4.5f, "https://images.telepizza.com/vol/es/images/content/promociones/ifj20_c.png\n"),
        Order("Carne Salsa",4.5f, "https://images.telepizza.com/vol/es/images/content/promociones/iab.3p06_c.png"),
        Order("Peperoni", 4.5f, "https://images.telepizza.com/vol/es/images/content/promociones/i2p17_c.png"),
        Order("Atún", 4.5f, "https://images.telepizza.com/vol/es/images/content/promociones/ipz00_c.png"),
        Order("Bacon", 4.5f, "https://images.telepizza.com/vol/es/images/content/promociones/iab.3p05_c.png"),
        Order("Pollo", 4.5f, "https://images.telepizza.com/vol/es/images/content/promociones/ifj20_c.png"),
        Order("Jamón Serrano", 4.5f, "https://images.telepizza.com/vol/es/images/content/promociones/iab.3p06_c.png\n"),
        Order("Queso", 4.5f, "https://images.telepizza.com/vol/es/images/content/promociones/i2p17_c.png"),
        Order("Jamón Dulce", 4.5f, "https://images.telepizza.com/vol/es/images/content/promociones/ipz00_c.png\n"),
        Order("Doble Queso", 4.5f, "https://images.telepizza.com/vol/es/images/content/promociones/ipz00_c.png"),
        Order("Champiñones", 4.5f, "https://images.telepizza.com/vol/es/images/content/promociones/iab.3p05_c.png"),
        Order("Piña", 4.5f, "https://images.telepizza.com/vol/es/images/content/promociones/ifj20_c.png"),
        Order("Daniel", 4.5f, "https://images.telepizza.com/vol/es/images/content/promociones/iab.3p06_c.png"),
        Order("Daniela", 4.5f, "https://images.telepizza.com/vol/es/images/content/promociones/i2p17_c.png"),
        Order("Albert", 4.5f, "https://images.telepizza.com/vol/es/images/content/promociones/ipz00_c.png"),
        Order("Alberto", 4.5f, "https://images.telepizza.com/vol/es/images/content/promociones/iab.3p05_c.png"),
    )

    override suspend fun getDatas() :UserLogin{
        return withContext(Dispatchers.IO){
            UserLogin(email, password);
        }
    }

    override suspend fun getOrderList(): MutableList<Order> {
       return withContext(Dispatchers.IO){
              listOrders
       }
    }
}