package com.example.spring

import org.springframework.stereotype.Repository

@Repository
class PetRepository {

    private val pets: MutableList<Pet> = mutableListOf()

    fun findById(id: Int): Pet? = pets.getOrNull(id)

    fun add(pet: Pet) {
        pets.add(pet)
    }
}
