package tachiyomi.core.prefs

/**
 * A wrapper around an application preferences store. Implementations of this interface should
 * persist these preferences on disk.
 */
interface PreferenceStore {

  /**
   * Returns an [String] preference for this [key].
   */
  fun getString(key: String, defaultValue: String = ""): Preference<String>

  /**
   * Returns a [Long] preference for this [key].
   */
  fun getLong(key: String, defaultValue: Long = 0): Preference<Long>

  /**
   * Returns an [Int] preference for this [key].
   */
  fun getInt(key: String, defaultValue: Int = 0): Preference<Int>

  /**
   * Returns a [Float] preference for this [key].
   */
  fun getFloat(key: String, defaultValue: Float = 0f): Preference<Float>

  /**
   * Returns a [Boolean] preference for this [key].
   */
  fun getBoolean(key: String, defaultValue: Boolean = false): Preference<Boolean>

  /**
   * Returns a [Set<String>] preference for this [key].
   */
  fun getStringSet(key: String, defaultValue: Set<String> = emptySet()): Preference<Set<String>>

  /**
   * Returns preference of type [T] for this [key]. The [serializer] and [deserializer] function
   * must be provided.
   */
  fun <T> getObject(
    key: String,
    defaultValue: T,
    serializer: (T) -> String,
    deserializer: (String) -> T
  ): Preference<T>

}
