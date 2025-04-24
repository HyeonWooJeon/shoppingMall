package com.example.shoppingmall

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.shoppingmall.dataClass.AdItemAndButton
import com.example.shoppingmall.dataClass.Coupon
import com.example.shoppingmall.dataClass.FullAdItem
import com.example.shoppingmall.dataClass.HorizontalItem1
import com.example.shoppingmall.dataClass.HorizontalItem2
import com.example.shoppingmall.dataClass.ItemType
import com.example.shoppingmall.dataClass.ViewPagerItem
import com.example.shoppingmall.mock.Mock
import com.example.shoppingmall.ui.theme.ShoppingMallTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ShoppingMallTheme {
                ShoppingMall()
            }
        }
    }
}

@Composable
fun ShoppingMall() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.cg_10)),
       horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ShoppingMallHeader()
        ShoppingMallMain(context=context)
    }
}
@Composable
fun ShoppingMallHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.cg_10))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.icon_sale),
            contentDescription = null,
//            colorFilter = ColorFilter.tint(Color.Black),
            modifier = Modifier.size(30.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Mall",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}


@Composable
fun ShoppingMallMain(context: Context) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.cg_10))
           ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MockListView(context=context)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MockListView(context:Context) {
    val itemList = Mock.mockData()
    Log.d("MainActivity", "itemList: $itemList")

    TextField(
        value = "",
        onValueChange = {},
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        placeholder = { Text("검색", style = TextStyle(fontSize = 14.sp)) },
        singleLine = true
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.cg_10))

    ) {
        items(itemList) { item ->
            when (item.type) {
                ItemType.ViewPager -> ViewPager(viewPagerItem = item.content as ViewPagerItem)
                ItemType.FullAd -> FullAd(fullAdItem = item.content as FullAdItem)
                ItemType.Horizontal1 -> HorizontalList1(horizontalItem = item.content as HorizontalItem1, context = context)
                ItemType.Coupon -> CouponList(CouponItem = item.content as Coupon ,context = context)
                ItemType.Horizontal2 -> HorizontalList2(horizontalItem = item.content as HorizontalItem2, context = context)
                ItemType.AdButton -> AdItemAndButton(adItemAndButton = item.content as AdItemAndButton)
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ViewPager(viewPagerItem: ViewPagerItem) {
    val pagerState = rememberPagerState()
    val corutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit){
        while(true){
            delay(4000L)
            corutineScope.launch {
                val nextState = (pagerState.currentPage + 1)%viewPagerItem.images.size
                pagerState.animateScrollToPage(nextState)
            }
        }
    }
    HorizontalPager(
        count = viewPagerItem.images.size,
        state = pagerState
        ) { page ->
        Image(painter = rememberAsyncImagePainter(model = viewPagerItem.images[page]),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .height(300.dp),
            contentScale = ContentScale.FillHeight)
    }
}

@Composable
fun FullAd(fullAdItem: FullAdItem) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = rememberAsyncImagePainter(model = fullAdItem.imageUrl),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = fullAdItem.title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(20.dp),
            fontSize = 20.sp
        )
    }
}

@Composable
fun AdItemAndButton(adItemAndButton: AdItemAndButton) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = rememberAsyncImagePainter(model = adItemAndButton.imageUrl),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.FillWidth
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = adItemAndButton.title,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            TextButton(
                onClick = {},
                modifier = Modifier
                    .height(40.dp)
                    .background(
                        color = colorResource(id = R.color.bl_60),
                        shape = MaterialTheme.shapes.small
                    ),
                border = BorderStroke(1.dp, color = colorResource(id = R.color.bl_60))
            ) {
                Text(text = adItemAndButton.buttonText, color = Color.White)
            }
        }
    }
}

@Composable
fun HorizontalList1(horizontalItem: HorizontalItem1, context: Context) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = horizontalItem.title, fontWeight = FontWeight.Bold)
        LazyRow {
            items(horizontalItem.items) { sellItem ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .size(130.dp, 180.dp)
                        .clickable {
                            val intent = Intent(context, ItemDetailActivity::class.java).apply {
                                putExtra("name", sellItem.productName)
                                putExtra("price", sellItem.price)
                                putExtra("image", sellItem.imageUrl)
                            }
                            context.startActivity(intent)
                        }
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(model = sellItem.imageUrl),
                        contentDescription = null,
                        modifier = Modifier.size(100.dp, 120.dp),
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = sellItem.productName,
                        lineHeight = 12.sp,
                        fontSize = 12.sp,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(horizontal = 5.dp)
                    )
                    Text(
                        text = sellItem.price,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}

@Composable
fun HorizontalList2(horizontalItem: HorizontalItem2, context: Context) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = horizontalItem.title, fontWeight = FontWeight.Bold)
        LazyRow {
            items(horizontalItem.items) { sale ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .size(140.dp, 150.dp)
                        .clickable {
                            val intent = Intent(context, ItemDetailActivity::class.java).apply {
                                putExtra("name", sale.name)
                                putExtra("price", sale.price.toString())
                                putExtra("image", sale.imageUrl)
                            }
                            context.startActivity(intent)
                        }
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(model = sale.imageUrl),
                        contentDescription = null,
                        modifier = Modifier.size(100.dp, 90.dp),
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = sale.name,
                        lineHeight = 12.sp,
                        fontSize = 13.sp,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(horizontal = 5.dp)
                    )
                    Text(
                        text = sale.price.toString(),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}

@Composable
fun CouponList(CouponItem: Coupon, context: Context) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 20.dp, end = 20.dp)
    ) {
        Text(text = CouponItem.title,
            fontWeight = FontWeight.Bold
        )
        LazyRow{
            items(CouponItem.items) { Item ->
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    modifier= Modifier
                        .size(150.dp,140.dp)
                        .clickable {
                            val Intent = Intent(context, ItemDetailActivity::class.java).apply {
                                putExtra("name", Item.name)
                                putExtra("price", Item.coupon)
                                putExtra("imageUrl", Item.imageUrl)
                            }
                            context.startActivity(Intent)
                        }
                ) {
                    Image(painter = rememberAsyncImagePainter(model = Item.imageUrl),
                        contentDescription = null,
                        modifier = Modifier.size(100.dp),
                        contentScale = ContentScale.Fit
                    )
                    Text(text = Item.name,
                        fontSize = 12.sp,
                        lineHeight = 12.sp,
                        maxLines = 1, // 텍스트가 한 줄로 제한됩니다.
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(text = Item.coupon,
                        fontSize = 15.sp,
                        color = Color.Red
                    )

                    Log.d("MainActivity", "couponItem: ${Item.imageUrl}")
                }
            }
        }
    }
    Spacer(modifier = Modifier.height(20.dp))
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ShoppingMallTheme {
        ShoppingMallHeader()
    }
}