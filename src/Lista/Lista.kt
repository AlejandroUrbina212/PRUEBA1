package Lista

import tarea.Tarea


class Lista (
        val nombre : String,
        private var tareas : ArrayList<Tarea> = ArrayList()
) {
    fun findTarea(name: String): Tarea? {
        val filteredTarea = tareas.filter { it.name == name }
        if (filteredTarea.count() > 0) {
            return filteredTarea[0]
        }
        return null
    }
    fun addTarea(tarea: Tarea): Boolean{
      if (findTarea(tarea.name)==null){
          this.tareas.add(tarea)
          return true
      }
      return false
    }
    fun mostrarTareas():String{
        var listaDeTareas : String = ""
        for (i in tareas.indices){
            listaDeTareas = "${i+1}. ${tareas[i]}"
        }
        return listaDeTareas
    }
    override fun toString(): String {
        val tareas = tareas.map {it.name}.joinToString ()
        return """
            Lista:
                Name: $nombre
                Tareas: $tareas
        """.trimIndent()
    }
}