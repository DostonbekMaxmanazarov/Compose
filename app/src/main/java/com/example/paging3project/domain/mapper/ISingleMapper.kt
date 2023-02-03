package com.example.paging3project.domain.mapper

interface ISingleMapper<T, R> {
    operator fun invoke(value: T): R
}