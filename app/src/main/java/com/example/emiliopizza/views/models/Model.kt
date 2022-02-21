package com.example.emiliopizza.views.models

import com.example.emiliopizza.views.interfaces.ModelData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Model() : ModelData {
    val email: String = "admin@gmail.com"
    val password: String = "1234"

    val listOrders = arrayListOf<Order>(
        Order("Patata", 4.5f, "https://images.telepizza.com/vol/es/images/content/promociones/ifj20_c.png\n"),
        Order("Carne Salsa",7.99f, "https://images.telepizza.com/vol/es/images/content/promociones/iab.3p06_c.png"),
        Order("Peperoni", 6f, "https://images.telepizza.com/vol/es/images/content/promociones/i2p17_c.png"),
        Order("Atún", 5.70f, "https://images.telepizza.com/vol/es/images/content/promociones/ipz00_c.png"),
        Order("Bacon", 9.0f, "https://images.telepizza.com/vol/es/images/content/promociones/iab.3p05_c.png"),
        Order("Pollo", 6.50f, "https://images.telepizza.com/vol/es/images/content/promociones/ifj20_c.png"),
        Order("Jamón Serrano", 7.0f, "https://images.telepizza.com/vol/es/images/content/promociones/iab.3p06_c.png\n"),
        Order("Queso", 8.0f, "https://images.telepizza.com/vol/es/images/content/promociones/i2p17_c.png"),
        Order("Jamón Dulce", 4.0f, "https://images.telepizza.com/vol/es/images/content/promociones/ipz00_c.png\n"),
        Order("Doble Queso", 11.0f, "https://images.telepizza.com/vol/es/images/content/promociones/ipz00_c.png"),
        Order("Champiñones", 6.50f, "https://images.telepizza.com/vol/es/images/content/promociones/iab.3p05_c.png"),
        Order("Piña", 3.0f, "https://images.telepizza.com/vol/es/images/content/promociones/ifj20_c.png"),
        Order("Bordes Rellonos", 11.5f, "https://images.telepizza.com/vol/es/images/content/promociones/iab.3p06_c.png"),
        Order("Barbacoa", 8.99f, "https://images.telepizza.com/vol/es/images/content/promociones/i2p17_c.png"),
        Order("Albe", 4.5f, "https://images.telepizza.com/vol/es/images/content/promociones/ipz00_c.png"),
        Order("Alberto", 5.0f, "https://images.telepizza.com/vol/es/images/content/promociones/iab.3p05_c.png"),
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