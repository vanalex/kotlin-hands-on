package org.example.secondaryconstructors

class GardenItem(val name: String) {
    var material: Material = Material.Plastic

    constructor(name: String, material: Material) : this(name){
        this.material = material
    }
    constructor(material: Material): this("Strange thing", material)

    override fun toString() = "$material $name"
}