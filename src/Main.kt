package main
import Lista.Lista
import tarea.Tarea
import kotlin.system.exitProcess

fun start(): String{
    return """
        MENU:
        1. Crear lista de tareas
        2. Salir
    """.trimIndent()
}

fun menu(): String {
    return """
        MENU:
        1. Crear lista de tareas
        2. Ver todas las listas de tareas
        3. Seleccionar una lista de tareas
        4. Salir
    """.trimIndent()
}
fun menu2(): String {
    return """
        MENU:
        1. Deseleccionar lista actual
        2. Agregar una tarea
        3. Completar Una tarea
        4. Ver todas las tareas en una lista
        5. Salir
    """.trimIndent()
}




fun main(args: Array<String>) {
    val agenda = ArrayList<Lista>()
    var wantsToContinue = true
    do {
        if (agenda.count()==0){
            println(start())
            print("Ingrese una opcion del menu (1 - 2): ")
            val optionstart = readLine()!!.toInt()
            when (optionstart) {
                1 -> {
                    var wantsToContinue1 = true
                    do {
                        println(menu())
                        print("Ingrese una opcion del menu (1 - 4): ")
                        val optionmenu = readLine()!!.toInt()
                        when (optionmenu){
                            1 ->{
                                print("Ingrese el nombre de su nueva lista de tareas: ")
                                val nombreNewLista = readLine()!!.toString()
                                val filteredLista = agenda.filter { it.nombre == nombreNewLista }
                                if (filteredLista.count() > 0) {
                                    println("Esta Lista ya existe")
                                }else{
                                    val newLista = Lista(nombreNewLista)
                                    agenda.add(newLista)
                                    print("Se ha agregado su nueva lista")
                                }

                            }
                            2 ->{
                                println("Se muestra la agenda con todas las listas")
                                println(agenda.toString())
                            }
                            3 -> {
                                var MenuDeTareas: String = ""
                                for (i in agenda.indices) {
                                    MenuDeTareas = "${i + 1}. ${agenda[i]}"
                                    print("$MenuDeTareas \n")
                                }
                                print("Ingrese el número de la lista de tareas que desea seleccionar: ")
                                val numeroMenuDeTareas: Int = readLine()!!.toInt()
                                val listaSeleccionada = agenda.get(numeroMenuDeTareas-1)
                                println("has seleccionado la Lista ${listaSeleccionada}")


                                var wantsToContinue2 = true
                                do{
                                    println(menu2())
                                    print("Ingrese una opcion del menu (1 - 5): ")
                                    val optionmenu2 = readLine()!!.toInt()
                                    when (optionmenu2){


                                        1 -> {
                                            wantsToContinue1=false
                                        }
                                        2 ->{
                                            print("Ingrese el nombre de la nueva tarea: ")
                                            val nombretarea: String = readLine()!!.toString()
                                            val newTarea = Tarea (nombretarea)

                                            if (listaSeleccionada.addTarea(newTarea)){
                                                println("Se ha agregado la tarea")
                                            }else{
                                                print("La tarea especificada ya existe")
                                            }
                                        }
                                        3 -> {

                                        }
                                        4 ->{
                                            print(listaSeleccionada.mostrarTareas())
                                        }
                                        5 ->{
                                            wantsToContinue2=false
                                        }
                                    }
                                }while(wantsToContinue2)






                            }
                            4 -> {
                                wantsToContinue1 = false

                            }

                        }

                    } while (wantsToContinue1)


                }
                2 ->{
                    wantsToContinue=false
                }
            }
        }

    }while (wantsToContinue)
}



