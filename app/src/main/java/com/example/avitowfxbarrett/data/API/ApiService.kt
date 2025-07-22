package com.example.avitowfxbarrett.data.API

import com.example.avitowfxbarrett.data.model.Address
import com.example.avitowfxbarrett.data.model.Attachment
import com.example.avitowfxbarrett.data.model.Category
import com.example.avitowfxbarrett.data.model.Chat
import com.example.avitowfxbarrett.data.model.Favorite
import com.example.avitowfxbarrett.data.model.LoginRequest
import com.example.avitowfxbarrett.data.model.LoginResponse
import com.example.avitowfxbarrett.data.model.Message
import com.example.avitowfxbarrett.data.model.Notification
import com.example.avitowfxbarrett.data.model.PriceHistory
import com.example.avitowfxbarrett.data.model.Product
import com.example.avitowfxbarrett.data.model.Promotion
import com.example.avitowfxbarrett.data.model.Report
import com.example.avitowfxbarrett.data.model.Review
import com.example.avitowfxbarrett.data.model.Role
import com.example.avitowfxbarrett.data.model.Statistic
import com.example.avitowfxbarrett.data.model.Type
import com.example.avitowfxbarrett.data.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {

    @GET("Roles")
    suspend fun getRoles(): List<Role>

    @GET("Roles/{id}")
    suspend fun getRoleById(@Path("id") id: Int): Role

    @GET("Roles/GetRoleByName/{name}")
    suspend fun getRoleByName(@Path("name") name: String): Role?

    @POST("Roles")
    suspend fun insertRole(@Body role: Role): Role

    @PUT("Roles/{id}")
    suspend fun updateRole(@Path("id") id: Int, @Body role: Role): Response<Unit>

    @DELETE("Roles/{id}")
    suspend fun deleteRole(@Path("id") id: Int): Response<Unit>

    @DELETE("Roles/Reset")
    suspend fun deleteTableRoles(): Response<Unit>

    @GET("Users")
    suspend fun getUsers(): List<User>

    @GET("Users/{id}")
    suspend fun getUserById(@Path("id") id: Int): User

    @GET("Users/GetUserByEmail/{email}")
    suspend fun getUserByEmail(@Path("email") email: String): User?

    @GET("Users/GetUsersByIds/{ids}")
    suspend fun getUsersByIds(@Path("ids") ids: List<Int>): List<User>

    @POST("Users")
    suspend fun insertUser(@Body user: User): User

    @POST("Users/login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @PUT("Users/{id}")
    suspend fun updateUser(@Path("id") id: Int, @Body user: User): Response<Unit>

    @DELETE("Users/{id}")
    suspend fun deleteUser(@Path("id") id: Int): Response<Unit>

    @DELETE("Users/Reset")
    suspend fun deleteTableUsers(): Response<Unit>


    @GET("Types")
    suspend fun getTypes(): List<Type>

    @GET("Types/{id}")
    suspend fun getTypeById(@Path("id") id: Int): Type

    @GET("Types/GetTypeByName/{name}")
    suspend fun getTypeByName(@Path("name") name: String): Type?

    @POST("Types")
    suspend fun insertType(@Body type: Type): Type

    @PUT("Types/{id}")
    suspend fun updateType(@Path("id") id: Int, @Body type: Type): Response<Unit>

    @DELETE("Types/{id}")
    suspend fun deleteType(@Path("id") id: Int): Response<Unit>

    @DELETE("Types/Reset")
    suspend fun deleteTableTypes(): Response<Unit>


    @GET("Categories")
    suspend fun getCategories(): List<Category>

    @GET("Categories/{id}")
    suspend fun getCategoryById(@Path("id") id: Int): Category

    @GET("Categories/GetCategoryByName/{name}")
    suspend fun getCategoryByName(@Path("name") name: String): Category?

    @POST("Categories")
    suspend fun insertCategory(@Body category: Category): Category

    @PUT("Categories/{id}")
    suspend fun updateCategory(@Path("id") id: Int, @Body category: Category): Response<Unit>

    @DELETE("Categories/{id}")
    suspend fun deleteCategory(@Path("id") id: Int): Response<Unit>

    @DELETE("Categories/Reset")
    suspend fun deleteTableCategories(): Response<Unit>


    @GET("Addresses")
    suspend fun getAddresses(): List<Address>

    @GET("Addresses/{id}")
    suspend fun getAddressById(@Path("id") id: Int): Address

    @GET("Addresses/GetAddressesByUserId/{userId}")
    suspend fun getAddressesByUserId(@Path("userId") userId: Int): List<Address>

    @POST("Addresses")
    suspend fun insertAddress(@Body address: Address): Address

    @PUT("Addresses/{id}")
    suspend fun updateAddress(@Path("id") id: Int, @Body address: Address): Response<Unit>

    @DELETE("Addresses/{id}")
    suspend fun deleteAddress(@Path("id") id: Int): Response<Unit>

    @DELETE("Addresses/Reset")
    suspend fun deleteTableAddresses(): Response<Unit>

    @GET("Attachments")
    suspend fun getAttachments(): List<Attachment>

    @GET("Attachments/{id}")
    suspend fun getAttachmentById(@Path("id") id: Int): Attachment

    @GET("Attachments/GetAttachmentsByProductId/{productId}")
    suspend fun getAttachmentsByProductId(@Path("productId") productId: Int): List<Attachment>

    @POST("Attachments")
    suspend fun insertAttachment(@Body attachment: Attachment): Attachment

    @PUT("Attachments/{id}")
    suspend fun updateAttachment(@Path("id") id: Int, @Body attachment: Attachment): Response<Unit>

    @DELETE("Attachments/{id}")
    suspend fun deleteAttachment(@Path("id") id: Int): Response<Unit>

    @DELETE("Attachments/Reset")
    suspend fun deleteTableAttachments(): Response<Unit>


    @GET("Statistics")
    suspend fun getStatistics(): List<Statistic>

    @GET("Statistics/{id}")
    suspend fun getStatisticById(@Path("id") id: Int): Statistic

    @GET("Statistics/GetStatisticByProductId/{productId}")
    suspend fun getStatisticByProductId(@Path("productId") productId: Int): Statistic?

    @POST("Statistics")
    suspend fun insertStatistic(@Body statistic: Statistic): Statistic

    @PUT("Statistics/{id}")
    suspend fun updateStatistic(@Path("id") id: Int, @Body statistic: Statistic): Response<Unit>

    @DELETE("Statistics/{id}")
    suspend fun deleteStatistic(@Path("id") id: Int): Response<Unit>

    @DELETE("Statistics/Reset")
    suspend fun deleteTableStatistics(): Response<Unit>


    @GET("Products")
    suspend fun getProducts(): List<Product>

    @GET("Products/{id}")
    suspend fun getProductById(@Path("id") id: Int): Product

    @GET("Products/GetProductsByUserId/{userId}")
    suspend fun getProductsByUserId(@Path("userId") userId: Int): List<Product>

    @GET("Products/GetProductsByCategory/{categoryId}")
    suspend fun getProductsByCategory(@Path("categoryId") categoryId: Int): List<Product>

    @POST("Products")
    suspend fun insertProduct(@Body product: Product): Product

    @PUT("Products/{id}")
    suspend fun updateProduct(@Path("id") id: Int, @Body product: Product): Response<Unit>

    @DELETE("Products/{id}")
    suspend fun deleteProduct(@Path("id") id: Int): Response<Unit>

    @DELETE("Products/Reset")
    suspend fun deleteTableProducts(): Response<Unit>


    @GET("Reviews")
    suspend fun getReviews(): List<Review>

    @GET("Reviews/{id}")
    suspend fun getReviewById(@Path("id") id: Int): Review

    @GET("Reviews/GetReviewsByUserId/{userId}")
    suspend fun getReviewsByUserId(@Path("userId") userId: Int): List<Review>

    @POST("Reviews")
    suspend fun insertReview(@Body review: Review): Review

    @PUT("Reviews/{id}")
    suspend fun updateReview(@Path("id") id: Int, @Body review: Review): Response<Unit>

    @DELETE("Reviews/{id}")
    suspend fun deleteReview(@Path("id") id: Int): Response<Unit>

    @DELETE("Reviews/Reset")
    suspend fun deleteTableReviews(): Response<Unit>


    @GET("Favorites")
    suspend fun getFavorites(): List<Favorite>

    @GET("Favorites/{id}")
    suspend fun getFavoriteById(@Path("id") id: Int): Favorite

    @GET("Favorites/GetFavoritesByUserId/{userId}")
    suspend fun getFavoritesByUserId(@Path("userId") userId: Int): List<Favorite>

    @POST("Favorites")
    suspend fun insertFavorite(@Body favorite: Favorite): Favorite

    @DELETE("Favorites/{id}")
    suspend fun deleteFavorite(@Path("id") id: Int): Response<Unit>

    @DELETE("Favorites/Reset")
    suspend fun deleteTableFavorites(): Response<Unit>


    @GET("Chats")
    suspend fun getChats(): List<Chat>

    @GET("Chats/{id}")
    suspend fun getChatById(@Path("id") id: Int): Chat

    @GET("Chats/GetChatsByUserId/{userId}")
    suspend fun getChatsByUserId(@Path("userId") userId: Int): List<Chat>

    @POST("Chats")
    suspend fun insertChat(@Body chat: Chat): Chat

    @PUT("Chats/{id}")
    suspend fun updateChat(@Path("id") id: Int, @Body chat: Chat): Response<Unit>

    @DELETE("Chats/{id}")
    suspend fun deleteChat(@Path("id") id: Int): Response<Unit>

    @DELETE("Chats/Reset")
    suspend fun deleteTableChats(): Response<Unit>


    @GET("Messages")
    suspend fun getMessages(): List<Message>

    @GET("Messages/{id}")
    suspend fun getMessageById(@Path("id") id: Int): Message

    @GET("Messages/GetMessagesByChatId/{chatId}")
    suspend fun getMessagesByChatId(@Path("chatId") chatId: Int): List<Message>

    @POST("Messages")
    suspend fun insertMessage(@Body message: Message): Message

    @PUT("Messages/{id}")
    suspend fun updateMessage(@Path("id") id: Int, @Body message: Message): Response<Unit>

    @DELETE("Messages/{id}")
    suspend fun deleteMessage(@Path("id") id: Int): Response<Unit>

    @DELETE("Messages/Reset")
    suspend fun deleteTableMessages(): Response<Unit>


    @GET("PriceHistory")
    suspend fun getPriceHistories(): List<PriceHistory>

    @GET("PriceHistory/{id}")
    suspend fun getPriceHistoryById(@Path("id") id: Int): PriceHistory

    @GET("PriceHistory/GetByProductId/{productId}")
    suspend fun getPriceHistoriesByProductId(@Path("productId") productId: Int): List<PriceHistory>

    @POST("PriceHistory")
    suspend fun insertPriceHistory(@Body priceHistory: PriceHistory): PriceHistory

    @DELETE("PriceHistory/{id}")
    suspend fun deletePriceHistory(@Path("id") id: Int): Response<Unit>

    @DELETE("PriceHistory/Reset")
    suspend fun deleteTablePriceHistory(): Response<Unit>


    @GET("Reports")
    suspend fun getReports(): List<Report>

    @GET("Reports/{id}")
    suspend fun getReportById(@Path("id") id: Int): Report

    @GET("Reports/GetByUserId/{userId}")
    suspend fun getReportsByUserId(@Path("userId") userId: Int): List<Report>

    @POST("Reports")
    suspend fun insertReport(@Body report: Report): Report

    @PUT("Reports/{id}")
    suspend fun updateReport(@Path("id") id: Int, @Body report: Report): Response<Unit>

    @DELETE("Reports/{id}")
    suspend fun deleteReport(@Path("id") id: Int): Response<Unit>

    @DELETE("Reports/Reset")
    suspend fun deleteTableReports(): Response<Unit>


    @GET("Promotions")
    suspend fun getPromotions(): List<Promotion>

    @GET("Promotions/{id}")
    suspend fun getPromotionById(@Path("id") id: Int): Promotion

    @GET("Promotions/GetByProductId/{productId}")
    suspend fun getPromotionsByProductId(@Path("productId") productId: Int): List<Promotion>

    @POST("Promotions")
    suspend fun insertPromotion(@Body promotion: Promotion): Promotion

    @PUT("Promotions/{id}")
    suspend fun updatePromotion(@Path("id") id: Int, @Body promotion: Promotion): Response<Unit>

    @DELETE("Promotions/{id}")
    suspend fun deletePromotion(@Path("id") id: Int): Response<Unit>

    @DELETE("Promotions/Reset")
    suspend fun deleteTablePromotions(): Response<Unit>


    @GET("Notifications")
    suspend fun getNotifications(): List<Notification>

    @GET("Notifications/{id}")
    suspend fun getNotificationById(@Path("id") id: Int): Notification

    @GET("Notifications/GetByUserId/{userId}")
    suspend fun getNotificationsByUserId(@Path("userId") userId: Int): List<Notification>

    @POST("Notifications")
    suspend fun insertNotification(@Body notification: Notification): Notification

    @PUT("Notifications/{id}")
    suspend fun updateNotification(@Path("id") id: Int, @Body notification: Notification): Response<Unit>

    @DELETE("Notifications/{id}")
    suspend fun deleteNotification(@Path("id") id: Int): Response<Unit>

    @DELETE("Notifications/Reset")
    suspend fun deleteTableNotifications(): Response<Unit>




}