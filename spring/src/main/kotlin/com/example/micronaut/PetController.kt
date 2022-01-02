package com.example.micronaut

import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post

@Controller("/micronaut/pets")
class PetController(
    private val petService: PetService
) {

    @Get("/{id}")
    fun pet(@PathVariable id: Int): Pet? = petService.findPetById(id)

    @Post
    fun add(@Body pet: Pet) {
        petService.addPet(pet)
    }
}
