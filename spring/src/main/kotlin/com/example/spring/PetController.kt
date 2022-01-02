package com.example.spring

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/spring/pets")
class PetController(
    private val petService: PetService
) {

    @GetMapping("/{id}")
    fun pet(@PathVariable id: Int): Pet? = petService.findPetById(id)

    @PostMapping
    fun add(@RequestBody pet: Pet) {
        petService.addPet(pet)
    }
}
