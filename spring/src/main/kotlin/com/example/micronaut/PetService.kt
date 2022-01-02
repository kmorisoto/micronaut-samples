package com.example.micronaut

import jakarta.inject.Singleton

@Singleton
class PetService(
    private val petRepository: PetRepository
) {

    fun findPetById(id: Int): Pet? = petRepository.findById(id)

    fun addPet(pet: Pet) {
        petRepository.add(pet)
    }
}
