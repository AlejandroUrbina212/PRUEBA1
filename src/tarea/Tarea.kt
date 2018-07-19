package tarea
class Tarea(
        val name: String,
        private var status: String = "Incompleta"
) {
    fun changeStatus(): Boolean {
        if (status == "Incompleta"){
            this.status=="Completa"

        }else{
            if (status=="Completa"){
                this.status=="Incompleta"
            }
        }
        return true

    }
    override fun toString(): String {
        val tarea = ""
        return """
            Tarea:
                Nombre: $name
                Estado: $status
        """.trimIndent()
    }
}