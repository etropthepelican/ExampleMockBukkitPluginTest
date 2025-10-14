package org.ExampleTest;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.*;
import org.mockbukkit.mockbukkit.MockBukkit;
import org.mockbukkit.mockbukkit.ServerMock;

class ExamplePluginTest {

    private static final String TESTING_NAME = "testName";
    private ServerMock server;

    @BeforeEach
    void setUp() {
        server = MockBukkit.mock();
    }

    @AfterEach
    void tearDown() {
        MockBukkit.unmock();
    }

    @Test
    void setPlayerMainHandItemToSpawner_ShouldHaveSpawnerInMainHand() {
        ItemStack spawner = new ItemStack(Material.SPAWNER);
        var player = server.addPlayer();
        player.getInventory().setItemInMainHand(spawner);

        Assertions.assertEquals(player.getInventory().getItemInMainHand(), spawner);
    }

    @Test
    void setNameOfPlayer(){
        var player = server.addPlayer();
        player.setName(TESTING_NAME);

        Assertions.assertEquals(TESTING_NAME, player.getName());
    }
}