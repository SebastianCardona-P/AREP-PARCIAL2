## Parcial 2 Sebastian Cardona Parra AREP


## Imagenes de prueba

### Imagenes antes de falla
1. imagen del front desplegado normal sin fallas:
![AntesProxi](img\principalProxyIndex.png)
2. Logs del proxy funcionando normalmente
![AntesProxi](img\logsProxyAntesPruebaFallo.png)
3. logs backend 2 funcionando normalmente, actual es quien recibe todas las peticiones:
![AntesBack2](img\logsBackend2AntesPruebaFallo.png)
4. logs backend 2 funcionando normalmente, actual es el pasivo y disponible ante fallos de backend 2:
![AntesBack1](img\logsBackend1AntesPruebaFallo.png)
5. Pagamos Back 2
![despuesBack2](img\logsBackend2FalloYApago.png)
6. Probamos hacer petición al proxy nuevamente desde el html
![despueshtml](img\nuevaPeticiónConFallo.png)
7. Revisamos los logs del proxy desplegado
![despuesproxylogs](img\logsProxyDespuesFallo.png)
8. Revisamos los logs del backend1 desplegado, ahora el principal
![despuesbackend1logs](img\logsBacken1DespuesFallo.png)


# Correr localmente
1. clone el proyecto con 
git clone https://github.com/SebastianCardona-P/AREP-PARCIAL2.git
cd AREP-PARCIAL2
2. corra el backend en el puerto 8081:
mvn clean install
mvn spring-boot:run
3. Corra el proxy en el puerto 8083:
mvn clean install
mvn spring-boot:run
4. vaya a http://localhost:8083/
5. haga pruebas


 