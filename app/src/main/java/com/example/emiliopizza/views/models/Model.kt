package com.example.emiliopizza.views.models

import com.example.emiliopizza.views.interfaces.ModelData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Model() : ModelData {
    private val email: String = "admin@gmail.com"
    private val password: String = "1234"

    private val listOrders = arrayListOf<Order>(
        Order("Patata", 4.5f, "https://images.telepizza.com/vol/es/images/content/promociones/ifj20_c.png",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis pharetra sit amet quam eget rutrum. Suspendisse facilisis eu ipsum sit amet aliquet. "),
        Order("Carne Salsa",7.99f, "https://images.telepizza.com/vol/es/images/content/promociones/iab.3p06_c.png",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras nec magna in mi ornare rutrum nec quis ipsum. Nam ac nisi in massa ultrices faucibus. Suspendisse et sollicitudin metus, in congue justo."),
        Order("Peperoni", 6f, "https://images.telepizza.com/vol/es/images/content/promociones/i2p17_c.png",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis pharetra sit amet quam eget rutrum. Suspendisse facilisis eu ipsum sit amet aliquet. Morbi tincidunt dignissim sem quis mollis. Cras nec magna in mi ornare rutrum nec quis ipsum."),
        Order("Atún", 5.70f, "https://images.telepizza.com/vol/es/images/content/promociones/ipz00_c.png",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis pharetra sit amet quam eget rutrum. Suspendisse facilisis eu ipsum sit amet aliquet. Morbi tincidunt dignissim sem quis mollis. Cras nec magna in mi ornare rutrum nec quis ipsum. Nam ac nisi in massa ultrices faucibus. Suspendisse et sollicitudin metus, in congue justo."),
        Order("Bacon", 9.0f, "https://images.telepizza.com/vol/es/images/content/promociones/iab.3p05_c.png",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis pharetra sit amet quam eget rutrum. Suspendisse facilisis eu ipsum sit amet aliquet. Morbi tincidunt dignissim sem quis mollis. Cras nec magna in mi ornare rutrum nec quis ipsum. Nam ac nisi in massa ultrices faucibus. Suspendisse et sollicitudin metus, in congue justo."),
        Order("Pollo", 6.50f, "https://images.telepizza.com/vol/es/images/content/promociones/ifj20_c.png",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis pharetra sit amet quam eget rutrum. Suspendisse facilisis eu ipsum sit amet aliquet. Morbi tincidunt dignissim sem quis mollis. Cras nec magna in mi ornare rutrum nec quis ipsum. Nam ac nisi in massa ultrices faucibus. Suspendisse et sollicitudin metus, in congue justo."),
        Order("Jamón Serrano", 7.0f, "https://images.telepizza.com/vol/es/images/content/promociones/iab.3p06_c.png",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis pharetra sit amet quam eget rutrum. Suspendisse facilisis eu ipsum sit amet aliquet.Suspendisse et sollicitudin metus, in congue justo."),
        Order("Queso", 8.0f, "https://images.telepizza.com/vol/es/images/content/promociones/i2p17_c.png",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis pharetra sit amet quam eget rutrum. Suspendisse facilisis eu ipsum sit amet aliquet. Morbi tincidunt dignissim sem quis mollis. Cras nec magna in mi ornare rutrum nec quis ipsum. Nam ac nisi in massa ultrices faucibus. Suspendisse et sollicitudin metus, in congue justo."),
        Order("Jamón Dulce", 4.0f, "https://images.telepizza.com/vol/es/images/content/promociones/ipz00_c.png",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis pharetra sit amet quam eget rutrum. Suspendisse facilisis eu ipsum sit amet aliquet. Morbi tincidunt dignissim sem quis mollis. Cras nec magna in mi ornare rutrum nec quis ipsum. Nam ac nisi in massa ultrices faucibus. Suspendisse et sollicitudin metus, in congue justo."),
        Order("Doble Queso", 11.0f, "https://images.telepizza.com/vol/es/images/content/promociones/ipz00_c.png",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis pharetra sit amet quam eget rutrum. Suspendisse facilisis eu ipsum sit amet aliquet. Morbi tincidunt dignissim sem quis mollis. in congue justo."),
        Order("Champiñones", 6.50f, "https://images.telepizza.com/vol/es/images/content/promociones/iab.3p05_c.png",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis pharetra sit amet quam eget rutrum. Suspendisse facilisis eu ipsum sit amet aliquet. Morbi tincidunt dignissim sem quis mollis. Cras nec magna in mi ornare rutrum nec quis ipsum. Nam ac nisi in massa ultrices faucibus. Suspendisse et sollicitudin metus, in congue justo."),
        Order("Piña", 3.0f, "https://images.telepizza.com/vol/es/images/content/promociones/ifj20_c.png",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis pharetra sit amet quam eget rutrum. Suspendisse facilisis eu ipsum sit amet aliquet. Morbi tincidunt dignissim sem quis mollis. Suspendisse et sollicitudin metus, in congue justo."),
        Order("Bordes Rellonos", 11.5f, "https://images.telepizza.com/vol/es/images/content/promociones/iab.3p06_c.png",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis pharetra sit amet quam eget rutrum. Cras nec magna in mi ornare rutrum nec quis ipsum. Nam ac nisi in massa ultrices faucibus. Suspendisse et sollicitudin metus, in congue justo."),
        Order("Barbacoa", 8.99f, "https://images.telepizza.com/vol/es/images/content/promociones/i2p17_c.png",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis pharetra sit amet quam eget rutrum. Suspendisse facilisis eu ipsum sit amet aliquet. Morbi tincidunt dignissim sem quis mollis. Cras nec magna in mi ornare rutrum nec quis ipsum. Nam ac nisi in massa ultrices faucibus. Suspendisse et sollicitudin metus, in congue justo."),
        Order("Albe", 4.5f, "https://images.telepizza.com/vol/es/images/content/promociones/ipz00_c.png",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis pharetra sit amet quam eget rutrum. Suspendisse facilisis eu ipsum sit amet aliquet. Morbi tincidunt dignissim sem quis mollis. Cras nec magna in mi ornare rutrum nec quis ipsum. Nam ac nisi in massa ultrices faucibus. Suspendisse et sollicitudin metus, in congue justo."),
        Order("Alberto", 5.0f, "https://images.telepizza.com/vol/es/images/content/promociones/iab.3p05_c.png",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis pharetra sit amet quam eget rutrum. Suspendisse facilisis eu ipsum sit amet aliquet. Morbi tincidunt dignissim sem quis mollis."),
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