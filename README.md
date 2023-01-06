# ServerLinks
![Badge](https://github.com/Altruiis/ServerLinks/actions/workflows/devbuild.yml/badge.svg)

Small plugin to set media links to advertise to your players

## Links
ServerLinks supports any kind of link, through `/sl set <link> <value>`, but it comes with a few defaults which serve as examples:
- appeals
- discord
- youtube
- forum
- instagram
- store
- vote (set separately)

## Commands
- `/sl` - Main command
- `/sl info` - View misc. info about the plugin with links to this repo and the plugin page
- `/sl help` - View all commands
- `/sl set <link> <value>` - Set a link
- `/sl reload` - Reload the config
- `/sl link <link>` - View a specific link
- `/sl gui` - List all links in a GUI format
- `/sl list` - List all links
- `/sl vote` - View vote links
- `/sl reset <link>` - Reset a link, removing it from the config

## Permissions
- `links.*` - All permissions
- `links.set` - Access to `/sl set`
- `links.reset` - Access to `/sl reset`
- `links.reload` - Access to `/sl reload`
