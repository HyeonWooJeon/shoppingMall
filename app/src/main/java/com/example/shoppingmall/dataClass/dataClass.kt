package com.example.shoppingmall.dataClass

data class Item(
    val type: ItemType,
    val content: Any
)

enum class ItemType {
    ViewPager,
    FullAd,
    Horizontal1,
    Coupon,
    Horizontal2,
    AdButton
}

data class ViewPagerItem(
    val images: List<String> // 이미지는 URL 또는 로컬 이미지 경로
)

data class FullAdItem(
    val title: String,
    val imageUrl: String
)

data class AdItemAndButton(
    val title: String,
    val imageUrl: String,
    val buttonText: String
)

data class HorizontalItem1(
    val title: String,
    val items: List<SellItem>
)

data class SellItem(
    val productName: String,
    val price: String,
    val imageUrl: String
)

data class HorizontalItem2(
    val title: String,
    val items: List<Sale>
)

data class Sale(
    val imageUrl: String,
    val sale: String,
    val price: Int,
    val name: String,
    val badge: String? = null
)

data class Coupon(
  val title: String,
  val items: List<CouponItem>
)

data class CouponItem(
    val imageUrl: String,
    val name: String,
    val coupon: String
)

