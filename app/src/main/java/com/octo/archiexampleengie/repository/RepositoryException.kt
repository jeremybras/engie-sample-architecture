package com.octo.archiexampleengie.repository

class RepositoryException(
    override val message: String? = null,
    override val cause: Throwable? = null
) : Exception(message, cause)
