package com.example.spring

import org.springframework.stereotype.Service

@Service
class PetService(
    private val petRepository: PetRepository
) {

    fun findPetById(id: Int): Pet? = petRepository.findById(id)

    fun addPet(pet: Pet) {
        petRepository.add(pet)
    }
}
