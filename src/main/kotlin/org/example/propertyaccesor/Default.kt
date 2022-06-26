package org.example.propertyaccesor

class Default {
  var i: Int = 0
    get() {
      return field       // [1]
    }
    set(value) {
      field = value      // [2]
    }
}
