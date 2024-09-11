import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.util.UUID

data class Crime(
    val id: UUID = UUID.randomUUID(),
    var title: String,
    var isSolved: Boolean,
    val date: LocalDate
)
