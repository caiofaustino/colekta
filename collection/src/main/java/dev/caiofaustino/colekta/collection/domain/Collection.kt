package dev.caiofaustino.colekta.collection.domain

class Collection(
    val id: Int,
    val name: String,
    val collectableItems: List<CollectableItem>,
    val ownedItems: List<OwnedItem>,
)