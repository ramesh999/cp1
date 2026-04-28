package org.rk.cp1.org.rk.todo.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TodoTest {

    @Test
    void newTodo_startsAsNotCompletedAndWithoutCreatedAt() {
        Todo todo = new Todo();

        assertFalse(todo.isCompleted());
        assertNull(todo.getCreatedAt());
    }

    @Test
    void settersAndGetters_preserveAssignedValues() {
        Todo todo = new Todo();
        LocalDateTime createdAt = LocalDateTime.of(2026, 4, 27, 10, 30);

        todo.setId(5L);
        todo.setTitle("Buy groceries");
        todo.setDescription("Milk and eggs");
        todo.setCompleted(true);
        todo.setCreatedAt(createdAt);

        assertEquals(5L, todo.getId());
        assertEquals("Buy groceries", todo.getTitle());
        assertEquals("Milk and eggs", todo.getDescription());
        assertTrue(todo.isCompleted());
        assertEquals(createdAt, todo.getCreatedAt());
    }

    @Test
    void onCreate_setsCreatedAtToCurrentTime() {
        Todo todo = new Todo();
        LocalDateTime before = LocalDateTime.now().minusSeconds(1);

        todo.onCreate();

        LocalDateTime after = LocalDateTime.now().plusSeconds(1);
        assertNotNull(todo.getCreatedAt());
        assertFalse(todo.getCreatedAt().isBefore(before));
        assertFalse(todo.getCreatedAt().isAfter(after));
    }

    @Test
    void onCreate_overwritesExistingCreatedAtValue() {
        Todo todo = new Todo();
        LocalDateTime initial = LocalDateTime.of(2000, 1, 1, 0, 0);
        todo.setCreatedAt(initial);

        todo.onCreate();

        assertNotEquals(initial, todo.getCreatedAt());
    }

    @Test
    void title_acceptsNullValueAtModelLevel() {
        Todo todo = new Todo();

        todo.setTitle(null);

        assertNull(todo.getTitle());
    }

    @Test
    void title_acceptsBlankValueAtModelLevel() {
        Todo todo = new Todo();

        todo.setTitle("   ");

        assertEquals("   ", todo.getTitle());
    }
}

