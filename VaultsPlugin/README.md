# Minecraft Player Vaults Plugin
This is a simple plugin for Minecraft servers that allows players to store and retrieve items in a virtual "vault".

# Video
https://share.cleanshot.com/KsFDb4vk

# Installation
To install the plugin, follow these steps:

1. Download the plugin jar file.

2. Copy the jar file into the plugins folder of your Minecraft server.

3. Restart the server.
## Usage
To use the plugin, players can use the following command:

```
/vault
```

This will open a virtual inventory where the player can store and retrieve items. The items in the virtual inventory are saved to a file, so they will persist between server sessions.

## Code Overview
The plugin consists of a few different event handlers and utility methods. Here is a brief overview of each:

- onPlayerJoin: This event handler is triggered when a player joins the server. It loads the player's vault items from a file.

- onInventoryClose: This event handler is triggered when a player closes their vault inventory. It saves the items in the inventory to a file.

- storeItems: This utility method saves a list of items to a file.

- getItems: This utility method loads a list of items from a file.

- onCommand: This event handler is triggered when a player types the /vault command. It opens the player's vault inventory.

### Credits: 
This plugin was created by Dylan Wax.