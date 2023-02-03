package com.example.appnewkool.data.modeljson

import com.example.appnewkool.data.model.Product

fun ProductResponse.toProduct(): Product {
    return Product(
        id = this.id,
        tenXe = this.tenXe,
        hangXe = this.hangXe,
        kinhLai = this.kinhLai,
        suonTruoc = this.suonTruoc,
        khoangSau = this.khoangSau,
        kinhHau = this.kinhHau,
        tamGiac = this.tamGiac,
        noc = this.noc,
        image = this.image
    )
}

fun Product.toProductResponse(): ProductResponse {
    return ProductResponse(
        id = this.id,
        tenXe = this.tenXe,
        hangXe = this.hangXe,
        kinhLai = this.kinhLai,
        suonTruoc = this.suonTruoc,
        khoangSau = this.khoangSau,
        kinhHau = this.kinhHau,
        tamGiac = this.tamGiac,
        noc = this.noc,
        image = this.image
    )
}


fun List<ProductResponse>.toListProduct(): List<Product>{
    return this.map { it.toProduct() }
}

fun List<Product>.toListProductEntity(): List<ProductResponse>{
    return this.map { it.toProductResponse() }
}