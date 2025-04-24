package com.example.shoppingmall.mock

import com.example.shoppingmall.dataClass.AdItemAndButton
import com.example.shoppingmall.dataClass.Coupon
import com.example.shoppingmall.dataClass.CouponItem
import com.example.shoppingmall.dataClass.FullAdItem
import com.example.shoppingmall.dataClass.HorizontalItem1
import com.example.shoppingmall.dataClass.HorizontalItem2
import com.example.shoppingmall.dataClass.Item
import com.example.shoppingmall.dataClass.ItemType
import com.example.shoppingmall.dataClass.Sale
import com.example.shoppingmall.dataClass.SellItem
import com.example.shoppingmall.dataClass.ViewPagerItem

object Mock {
    fun mockData(): List<Item> {
        return listOf(
            Item(ItemType.ViewPager, mockViewPager()),
            Item(ItemType.FullAd, mockFullAd()),
            Item(ItemType.Horizontal1, mockHorizontal()),
            Item(ItemType.Coupon, mockCoupon()),
            Item(ItemType.Horizontal2, mockHorizontal2()),
            Item(ItemType.AdButton, mockAdButton())
        )
    }

    // ViewPager mock data
    private fun mockViewPager(): ViewPagerItem {
        return ViewPagerItem(
            images = listOf(
                "https://cdn.pixabay.com/photo/2023/04/28/09/59/mower-7956264_1280.jpg",
                "https://cdn.pixabay.com/photo/2014/11/16/15/15/field-533541_1280.jpg",
                "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg",
                "https://cdn.pixabay.com/photo/2014/04/14/20/11/pink-324175_1280.jpg"
            )
        )
    }

    // Full Ad mock data
    private fun mockFullAd(): FullAdItem {
        return FullAdItem(
            title = "장보기 위크",
            imageUrl = "https://cdn.pixabay.com/photo/2014/11/16/15/15/field-533541_1280.jpg"
        )
    }

    private fun mockAdButton():AdItemAndButton{
        return AdItemAndButton(
            title = "블랙프라이데이! 50% 할인",
            imageUrl = "https://cdn.pixabay.com/photo/2015/01/08/18/24/children-593313_1280.jpg",
            buttonText = "구매하러 가기"
        )
    }

    // Horizontal list mock data
    private fun mockHorizontal(): HorizontalItem1 {
        return HorizontalItem1(
            title = "이 주의 쇼핑 특가",
            items = listOf(
                SellItem("엑스코리아 30인치 FHD TV 모니터겸용", "149000", "https://images.freeimages.com/vhq/images/previews/fb1/price-tag-psd-templates-394247.jpg"),
                SellItem("루나립 듀얼 모니터 암, 블랙, 1개", "93000", "https://images.freeimages.com/images/previews/233/buddah-statue-in-hong-kong-1222149.jpg"),
                SellItem("클라유즈 프리미엄 패널 24인치 모니터 컴퓨터 게이밍 사무용 화이트", "140000","https://images.freeimages.com/clg/images/80/80273/beach-4_p.jpg"),
                SellItem("와이어뷰 60cm FHD 내장스피커 모니터", "129000", "https://images.freeimages.com/images/previews/233/buddah-statue-in-hong-kong-1222149.jpg")
            )
        )
    }
    private fun mockHorizontal2(): HorizontalItem2 {
        return HorizontalItem2(
            title = "이 상품은 필수로 사야해!",
            items = listOf(
                Sale(
                    "https://img.freepik.com/free-photo/young-adult-organizing-documents_23-2149396695.jpg?size=626&ext=jpg&ga=GA1.2.1575512813.1668176396&semt=sph",
                    "지금 15% 할인 중!",
                    22000,
                    "코끼리 파일집",
                    "무료배송"
                ),
                Sale(
                    "https://img.freepik.com/free-photo/organized-cabinet-at-home_23-2148857501.jpg?size=626&ext=jpg&ga=GA1.2.1575512813.1668176396&semt=sph",
                    "지금 25% 할인 중!",
                    34000,
                    "나리 서랍 정리함",
                    null
                ),
                Sale(
                    "https://img.freepik.com/free-photo/close-up-classify-male-underwear_23-2148857515.jpg?size=626&ext=jpg&ga=GA1.2.1575512813.1668176396&semt=sph",
                    "지금 29% 할인 중!",
                    12000,
                    "더있소 킹콩 속옷 정리함",
                    "무료배송"
                ),
                Sale(
                    "https://images.freeimages.com/images/previews/46e/red-beetle-1416148.jpg",
                    "지금 10% 할인 중!",
                    15000,
                    "코쿠리 보조배터리 흡착패드 화이트",
                    "무료배송"
                ),
                Sale(
                    "https://images.freeimages.com/images/previews/5a4/mail-box-1422055.jpg",
                    "지금 33% 할인 중!",
                    20000,
                    "소파 무선충전기 거치대 갤럭시 아이폰 디즈니에디션",
                    null
                ),
                Sale(
                    "https://images.freeimages.com/variants/htJPgwZuxUMTq4Vn3NDQ5THz/f4a36f6589a0e50e702740b15352bc00e4bfaf6f58bd4db850e167794d05993d",
                    "지금 52% 할인 중!",
                    30000,
                    "15인치 초슬림 DEX 포터블 HDR 휴대용 모니터",
                    "무료배송"
                ),
                Sale(
                    "https://images.freeimages.com/images/previews/802/kaaba-mecca-city-center-saudiarb-muslims-masjid-haram-mosque-prayer-1441239.jpg",
                    "지금 15% 할인 중!",
                    25000,
                    "청승테크 3in1 고속 무선충전기 거치대 삼성 갤럭시 아이폰 애플워치 갤럭시워치 QC3.0",
                ),
                Sale(
                    "https://images.freeimages.com/variants/N2q96guqeZAWUYwFTZWvi1WC/f4a36f6589a0e50e702740b15352bc00e4bfaf6f58bd4db850e167794d05993d",
                    "지금 60% 할인 중!",
                    50000,
                    "자동 출 전기 포트 온도 조절 티 메이커 보온 분유 급 수 무선",
                    "무료배송"
                ),
                Sale(
                    "https://images.freeimages.com/images/previews/4fe/wiene-museum-1217586.jpg",
                    "지금 72% 할인 중!",
                    10000,
                    "라면3개도 거뜬! 원터치 멀티 라면포트 1.8L+계란찜판 증정",
                ),
                Sale(
                    "https://images.freeimages.com/images/previews/e56/run-away-1555225.jpg",
                    "지금 15% 할인 중!",
                    20000,
                    "델가체 기본형 스탠드 선풍기 DXF-2260",
                ),
                Sale(
                    "https://images.freeimages.com/images/previews/f28/silver-laptop-1-1616821.jpg",
                    "지금 48% 할인 중!",
                    30000,
                    "델로이 충전식 캠핑용 선풍기 타프팬",
                    "무료배송"
                )
            )
        )
    }

    private fun mockCoupon(): Coupon {
        return Coupon(
            title = "특가 쿠폰",
            items = listOf(
                CouponItem("https://img.freepik.com/free-vector/online-shopping-concept-illustration_114360-1084.jpg?size=626&ext=jpg&ga=GA1.2.1575512813.1668176396","의류 쿠폰! 겨울 코트 장만하세요","~84% 쿠폰"),
                CouponItem( "https://img.freepik.com/free-vector/black-friday-concept-illustration_114360-3667.jpg?size=338&ext=jpg&ga=GA1.2.1575512813.1668176396", "블랙 프라이데이! 두번 다시 없을 할인 쿠폰", "~77% 쿠폰"),
                CouponItem("https://img.freepik.com/free-photo/basket-full-of-vegetables_1112-316.jpg?size=626&ext=jpg&ga=GA1.2.1575512813.1668176396", "제철 과일 할인 쿠폰!", "~57% 쿠폰"),
                CouponItem("https://img.freepik.com/free-vector/seasonal-sale-discounts-presents-purchase-visiting-boutiques-luxury-shopping-price-reduction-promotional-coupons-special-holiday-offers-vector-isolated-concept-metaphor-illustration_335657-2766.jpg?size=338&ext=jpg&ga=GA1.2.1575512813.1668176396", "장바구니 쿠폰! 최대 40%", "~40% 쿠폰"),
                CouponItem("https://img.freepik.com/free-photo/mega-sale-for-retail-with-pink-circle_23-2149656610.jpg?size=626&ext=jpg&ga=GA1.2.1575512813.1668176396&semt=sph", "메가 세일! 전 상품 할인 중!", "~20% 쿠폰")
            )
        )
    }


}