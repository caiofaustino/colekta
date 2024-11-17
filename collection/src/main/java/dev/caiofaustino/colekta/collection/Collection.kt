package dev.caiofaustino.colekta.collection

class Collection(
    val id: Int,
    val name: String,
    val collectableItems: List<CollectableItem>,
    val ownedItems: List<OwnedItem>,
)