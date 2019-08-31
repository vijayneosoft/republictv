package com.neosoft.republictv.data.exception


/**
 * Created by Vijay on 30/8/19.
 */

class ExceptionFactory {

    companion object {

        fun create(code: Int, message: String?): Exception {
            when (code) {
                422 -> {
                    return UserNotFoundException(message)
                }
                else -> return UserNotFoundException(message)
            }
        }
    }

}
