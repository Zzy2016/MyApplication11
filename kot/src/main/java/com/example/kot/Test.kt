package com.example.kot

class Test {

}

fun main() {
    print("------")

    var array = intArrayOf(3, 2, 5, 7, 6, 1, 4, 9, 8)

    for (i in 0..array.size - 1) {
        var j = i
        while (j > 0) {
            if (array[j] < array[j - 1]) {
                var temp = array[j]
                array[j] = array[j - 1]
                array[j - 1] = temp
            }
            j--
        }
    }

    for (i in 0..array.size - 1) {
        print(array[i])
    }

//    for (i in 0..array.size - 1) {//
//        for (j in 0..array.size-i - 2) {
//            if(array[j]>array[j+1]){
//                var temp=array[j]
//                array[j]=array[j+1]
//                array[j+1]=temp
//            }
//        }
//    }


//    for (i in 0..array.size - 1) {
//        var min = i  //当前待排序 最小值 index
//        //待排序
//        for (j in i..array.size - 1) {
//            if (array[min] > array[j]) {
//                min = j
//            }
//        }
//        var temp = array[min]
//        array[min] = array[i]
//        array[i] = temp
//    }


}